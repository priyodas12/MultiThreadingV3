package future;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return new Random().nextInt();
    }
}
