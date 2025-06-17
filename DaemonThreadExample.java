class DaemonTask extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon thread is running in background...");
            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted.");
            }
        }
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {
        // Create a daemon thread
        DaemonTask daemon = new DaemonTask();
        daemon.setDaemon(true); // Must be set before start()
        daemon.start();

        // Main thread runs for 5 seconds
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread running: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Main thread finished. Daemon will exit automatically.");
    }
}
