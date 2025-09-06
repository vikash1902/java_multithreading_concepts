package yield;

public class YieldThread extends Thread{

    public void run(){
        for(int i = 0; i < 10; i++){
            System.err.println("Child thread");
            Thread.yield();
        }
    }
}
