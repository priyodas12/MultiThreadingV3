package io.javalab.ThreadCreation;

import java.util.stream.IntStream;

public class FromThreadClass {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i->{
            new TestThread().start();
        });
    }
}

class TestThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName()+" started...");
    }
}
