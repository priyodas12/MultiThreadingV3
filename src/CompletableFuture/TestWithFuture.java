package CompletableFuture;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

/*
1. There is no way to complete the future. we can only attempt to cancel the task.
2. The get() method in the Future Interface is blocking operation
3. No support for exception handling
4. Multiple futures cannot be chained together.
5. Uses thread pool
* */

public class TestWithFuture {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {

        Future<Order> future1 = executorService.submit(()->Order.selectOrder("1010"));

        Order order = future1.get();
        System.out.println("get order: "+order);

        Future<Order> future2 = executorService.submit(()->Order.paymentForOrder(order));

        Order paymentDone = future2.get();
        System.out.println("payment order: "+paymentDone);

        Future<?> future3 = executorService.submit(()->Order.emailOrder(paymentDone));

        }
        catch (InterruptedException e) {
                e.printStackTrace();
        }
        catch (ExecutionException e) {
                e.printStackTrace();
        }


        executorService.shutdown();
        }

    }