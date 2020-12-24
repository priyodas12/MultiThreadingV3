package CompletableFuture;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {

        Future<Order> future1 = executorService.submit(new SelectOrderTask("abc"));

        Order order = future1.get();
        System.out.println(order);

        Future<String> future2 = executorService.submit(new PaymentTask(order));

        String confirmation = future2.get();
        System.out.println(confirmation);

        }
        catch (InterruptedException e) {
                e.printStackTrace();
        }
        catch (ExecutionException e) {
                e.printStackTrace();
        }

        for(int i=0;i<10;i++) {
            CompletableFuture.supplyAsync(() -> new SelectOrderTask("bdf"))
                    .thenAccept((order) -> {
                        new PaymentTask(order);
                    });
                }

        executorService.shutdown();
        }

    }