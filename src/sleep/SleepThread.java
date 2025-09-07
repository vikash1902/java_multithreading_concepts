package sleep;

public class SleepThread extends Thread{

    public void run(){
        for(int i = 0; i<10; i++){
            System.err.println("Hello i am lazy thread");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("I got interrupted");
            }
        }
    }
}
