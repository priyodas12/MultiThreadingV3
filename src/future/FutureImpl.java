package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        Future<Integer> fval=executorService.submit(new Task());

        System.out.println(Thread.currentThread().getName()+" prints "+fval.get());

        executorService.shutdown();
    }
}
