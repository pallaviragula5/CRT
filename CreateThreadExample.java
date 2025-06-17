class MyThread extends Thread {
    private String threadName;

    // Constructor
    MyThread(String name) {
        this.threadName = name;
    }

    // Override the run() method to define the task
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(500); // sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " has finished.");
    }
}

public class CreateThreadExample {
    public static void main(String[] args) {
        // Creating thread instances
        MyThread t1 = new MyThread("Thread-A");
        MyThread t2 = new MyThread("Thread-B");

        // Starting the threads
        t1.start();
        t2.start();
    }
}
