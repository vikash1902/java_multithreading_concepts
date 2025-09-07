package synchronization;

public class MyThread3 extends  Thread{
    Display display;

    public MyThread3(Display display){
        this.display = display;
    }

    public void run(){
        display.non_synchronized();
    }
}
