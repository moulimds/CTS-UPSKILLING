class MessagePrinter implements Runnable {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - " + i);
            try {
                Thread.sleep(500); // Sleep for half a second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Create two Runnable instances
        MessagePrinter printer1 = new MessagePrinter("Thread 1 is running");
        MessagePrinter printer2 = new MessagePrinter("Thread 2 is running");

        // Wrap in Thread objects and start them
        Thread thread1 = new Thread(printer1);
        Thread thread2 = new Thread(printer2);

        thread1.start();
        thread2.start();
    }
}
