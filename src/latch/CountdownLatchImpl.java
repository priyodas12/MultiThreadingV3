package latch;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchImpl {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);

        Thread t1=new Thread(new PublicThread(latch,"worker-1",1000));
        Thread t2=new Thread(new PublicThread(latch,"worker-2",2000));
        Thread t3=new Thread(new PublicThread(latch,"worker-3",3000));
        t1.start();
        t2.start();
        t3.start();

        latch.await();
        Thread t4=new Thread(new ExtraWork());
        t4.start();
    }
}
