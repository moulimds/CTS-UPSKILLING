import java.util.concurrent.*;
import java.util.*;

public class CallableE {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            callables.add(() -> {
                Thread.sleep(100);  // Simulate work
                return "Task " + taskId + " executed by " + Thread.currentThread().getName();
            });
        }
        List<Future<String>> futures = new ArrayList<>();
        for (Callable<String> task : callables) {
            futures.add(executor.submit(task));
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}
