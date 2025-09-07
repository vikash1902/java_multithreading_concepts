package synchronization;

public class MyThread1 extends Thread{

    Display d;
    int number;

    public  MyThread1(Display d, int number){
        this.d = d;
        this.number = number;
    }

    public void run(){
        d.printN(number);
    }
}
