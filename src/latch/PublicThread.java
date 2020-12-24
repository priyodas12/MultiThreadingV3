package latch;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class PublicThread implements Runnable{

    private CountDownLatch countDownLatch;
    private String name;
    private int delay;

    public PublicThread(CountDownLatch countDownLatch,String name,int delay) {
        this.countDownLatch = countDownLatch;
        this.name=name;
        this.delay=delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream.range(0,4).forEach(i-> System.out.println(i*3+" printed by "+name));
        countDownLatch.countDown();
    }
}
