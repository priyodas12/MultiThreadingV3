package execution;

import java.util.concurrent.atomic.AtomicLong;

public class TestEvenOdd {
    public static void main(String[] args) {
        AtomicLong number=new AtomicLong(1);
        Object lock=new Object();

        Even even=new Even(number,lock);
        Odd odd=new Odd(number,lock);

        new Thread(odd).start();
        new Thread(even).start();

    }
}
