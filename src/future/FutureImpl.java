package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureImpl {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        List<Integer> futureList=new ArrayList<>();
        //place holder for the object which will be returned from callable task
        IntStream.range(0,10)
                .forEach(i->{
                    Future<Integer> fval=executorService.submit(new Task());
                    try {
                        futureList.add(fval.get(1, TimeUnit.SECONDS));
                        System.out.println(Thread.currentThread().getName()+" prints "+fval.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }

                });

        futureList.stream().forEach(System.out::println);
        executorService.shutdown();
    }
}
