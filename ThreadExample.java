class MyThread extends Thread {
    private String threadName;

    // Constructor
    MyThread(String name) {
        threadName = name;
    }

    // Run method that defines the thread's task
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

public class ThreadExample {
    public static void main(String[] args) {
        // Create thread objects
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        // Start threads
        t1.start();
        t2.start();
    }
}
