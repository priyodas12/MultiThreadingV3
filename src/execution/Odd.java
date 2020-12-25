package execution;

import java.util.concurrent.atomic.AtomicLong;

public class Odd implements Runnable {

    private AtomicLong number;
    private Object lock;

    public Odd(AtomicLong number, Object lock) {
        this.number = number;
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            while(true){
                if(number.get()%2==0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("ODD::" + Thread.currentThread().getName() + " prints " + number);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    number.getAndIncrement();
                    lock.notifyAll();
                }
            }
        }
    }
}
