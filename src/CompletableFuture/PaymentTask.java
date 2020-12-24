package CompletableFuture;

import java.util.concurrent.Callable;

public class PaymentTask implements Callable<Object> {

    Order order;

    public PaymentTask(Order order) {
        this.order = order;
    }

    @Override
    public String call() throws Exception {
        System.out.println("payment successful! for "+order);
        return null;
    }
}
