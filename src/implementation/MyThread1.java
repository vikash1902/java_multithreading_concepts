package implementation;

// Creating thread using extending thread class
public class MyThread1 extends Thread{

    public void start(){
        super.start();
        System.err.println("From overridden start method");
    }

    public void run(){
        for(int i = 0; i <10;i++){
            System.err.println("Child thread --> " + i);
        }
    }

    public void run(int number) {
        for (int i = 0; i < number; i++) {
            System.err.println("Child thread --> " + i);
            String name = Thread.currentThread().getName();
            System.err.println(name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }
}
