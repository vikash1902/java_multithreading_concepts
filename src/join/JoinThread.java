package join;

public class JoinThread extends Thread{

    static Thread mt;

    public JoinThread(){}

    public JoinThread(Thread mt){
        JoinThread.mt = mt;
    }
    public void run(){
        try{
            mt.join();
        } catch (InterruptedException e) {

        }
        for(int i = 0; i<10; i++){
            System.err.println("Child Thread");
        }
    }
}
