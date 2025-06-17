class MyRunnable implements Runnable {
    private String threadName;

    // Constructor
    public MyRunnable(String name) {
        this.threadName = name;
    }

    // Define the task to run in the thread
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(500); // pause for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " has finished.");
    }
}

public class RunnableThreadExample {
    public static void main(String[] args) {
        // Create Runnable instances
        MyRunnable r1 = new MyRunnable("Thread-One");
        MyRunnable r2 = new MyRunnable("Thread-Two");

        // Wrap them in Thread objects
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        // Start the threads
        t1.start();
        t2.start();
    }
}
