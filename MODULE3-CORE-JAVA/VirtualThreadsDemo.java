import java.time.Duration;
import java.time.Instant;

public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting virtual threads...");

        Instant start = Instant.now();

        Thread[] threads = new Thread[100_000];

        for (int i = 0; i < 100_000; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // Lightweight task
                System.out.println("Hello from virtual thread " + Thread.currentThread());
            });
        }

        for (Thread t : threads) {
            t.join();  // Wait for all threads to finish
        }

        Instant end = Instant.now();
        System.out.println("Virtual threads completed in: " + Duration.between(start, end).toMillis() + " ms");
    }
}
