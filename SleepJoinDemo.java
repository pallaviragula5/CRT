class MyThread extends Thread {
    private String threadName;

    MyThread(String name) {
        this.threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " finished.");
    }
}

public class SleepJoinDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        System.out.println("Starting Thread-1...");
        t1.start();

        try {
            // Wait for t1 to finish before starting t2
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Starting Thread-2 after Thread-1 finishes...");
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}
