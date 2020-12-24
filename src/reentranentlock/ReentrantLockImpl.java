package reentranentlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockImpl {
    public static ReentrantLock lock=new ReentrantLock(true);

    //common resource
    public static List<Integer> commonList= new ArrayList<>();

    //common access method
    public static void editList(){
        try {
            //locking
            lock.lock();
            System.out.println("executing with "+Thread.currentThread().getName());
            Random randomInteger = new Random();
            commonList.add(randomInteger.nextInt());
            if(commonList.size()>0){
                //try to lock on the same lock available one more time
                lock.tryLock();
                Thread.sleep(1000);
                //get the count held locks
                System.out.println("hold count::"+lock.getHoldCount());
                //unlocking
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(commonList+" printed by "+Thread.currentThread().getName());
            //unlocking
            lock.unlock();
        }
    }



    public static void main(String[] args) {

        //create thread with anonymous inner class;
        Runnable r1= ReentrantLockImpl::editList;

        // created 10 thread which will try to access common method simultaneously
        IntStream.range(1,11).forEach(i->new Thread(r1).start());
    }

}
