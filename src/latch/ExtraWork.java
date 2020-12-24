package latch;

import java.util.stream.IntStream;

public class ExtraWork implements Runnable {
    @Override
    public void run() {

        IntStream.range(0,5).forEach(i-> System.out.println((i*i)+" printed by "+Thread.currentThread().getName()));
    }
}
