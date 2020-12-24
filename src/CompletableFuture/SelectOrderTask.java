package CompletableFuture;

import java.util.Random;
import java.util.concurrent.Callable;

public class SelectOrderTask implements Callable<Order> {

    String orderName;

    public SelectOrderTask(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public Order call() throws Exception {
        return new Order("abc", new Random().nextInt());
    }
}
