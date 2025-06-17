class MyThread extends Thread {
    public void run() {
        System.out.println("Running in thread: " + getName());
        System.out.println("Thread ID: " + getId());
    }
}

public class ThreadIDNameExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("Worker-1");
        t1.start();
    }
}
