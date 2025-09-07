package synchronization;

public class Display {

    public synchronized void printN(int number){
        for (int i = 1; i<= number; i++){
            System.err.print("Print number: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.err.println();
        }
    }

    public synchronized void wish(String name){
        for (int i = 1; i<=10; i++){
            System.err.print("Good morning: " + name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.err.println();
        }
    }

    public  void non_synchronized(){
        for (int i = 1; i<=10; i++){
            System.err.print("Non synchronized method: " );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.err.println();
        }
    }

    public void synchronized_block_using_this(){
        ;;;;;;;;; // lakhs of line of code
        synchronized (this){
            for (int i =0 ; i < 10; i++){
                System.err.println("Synchronized block using object level lock");
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }
        }
        ;;;;;;;;;; // lakh lines of code
    }

    public void synchronized_block_using_class_level_lock(){
        ;;;;;;;;; // lakhs of line of code
        synchronized (Display.class){
            for (int i =0 ; i < 10; i++){
                System.err.println("Synchronized block using class level lock");
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
            }
        }
        ;;;;;;;;;; // lakh lines of code
    }

    public void synchronized_block_using_object(){
        ;;;;;;;;; // lakhs of line of code
        Show show = new Show();
        synchronized (show){
            show.show();
        }
        ;;;;;;;;;; // lakh lines of code
    }
}
