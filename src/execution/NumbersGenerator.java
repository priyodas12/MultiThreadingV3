package execution;

public class NumbersGenerator {

    private int number=1;
    private int numberOfThread;
    private int totalNumberInSequence;

    public NumbersGenerator( int numberOfThread, int totalNumberInSequence) {
        super();
        this.numberOfThread = numberOfThread;
        this.totalNumberInSequence = totalNumberInSequence;
    }

    public void printNumbers(int result){
        synchronized (this){
            while(number<totalNumberInSequence-1){
                while(number%numberOfThread!=result){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" prints "+number++);
                    notifyAll();
                }
            }
        }
    }
}
