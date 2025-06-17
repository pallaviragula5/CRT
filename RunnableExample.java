class MyRunnable implements Runnable {
    private String threadName;

    // Constructor
    public MyRunnable(String name) {
        this.threadName = name;
    }

    // Override the run() method to define thread task
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " finished execution.");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        // Create Runnable objects
        MyRunnable r1 = new MyRunnable("Thread-1");
        MyRunnable r2 = new MyRunnable("Thread-2");

        // Wrap them in Thread objects and start
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
