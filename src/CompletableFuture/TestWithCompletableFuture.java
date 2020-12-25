package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
1. Uses fork join pool
2. takes both runnable and supplier function
3. combines both sync and async task
*/

public class TestWithCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture=CompletableFuture.supplyAsync(()->Order.selectOrder("1001"))
                .thenApplyAsync(Order::paymentForOrder)
                .thenAccept(Order::emailOrder);

        System.out.println(completableFuture.get());

    }
}
