package io.javalab.ThreadCreation;

import java.util.stream.IntStream;

public class FromRunnableInterface {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i->new Thread(new DemoThread()).start());
    }
}

class DemoThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started...");
    }
}
