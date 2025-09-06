package implementation;

// Creating thread using runnable interface
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println("Runnable interface --> " + i);
            String name = Thread.currentThread().getName();
            System.err.println(name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
