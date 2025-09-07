package join;

public class JoinThreadDemo {
    public static void main(String[] args){
        // join is used when a thread want to wait for another thread until the execution of that thread completes.
        // When we call join, it throws InterruptedException which is a checked exception
        // There are 3 constructor in join
        // a) public final void join();
        // b) public final void join(long millisecond);
        // c) public final void join(long millisecond, int nanosecond); each throws InterruptedException
        implement_join(); // there is high chance that main thread finishes at end

        // Child thread waiting for main thread
        child_waiting_for_main(); // the output is it will print main thread than execute child thread

        // deadlock condition 1 main thread waiting for child thread and child thread waiting for main thread
        dead_lock_condition1();

        // deadlock condition 2 main thread waiting for itself
        dead_lock_condition2();
    }

    public static void implement_join(){
        JoinThread joinThread = new JoinThread();
        joinThread.start();
        for (int i = 0; i < 10; i++){
            System.err.println("Main Thread");
        }
    }

    public static void child_waiting_for_main(){
        Thread mt = Thread.currentThread();
        JoinThread joinThread = new JoinThread(mt);
        joinThread.start();
        for (int i = 0; i<10; i++){
            System.err.println("Main thread");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
        }
    }

    public static void dead_lock_condition1(){
        Thread mt = Thread.currentThread();
        JoinThread joinThread = new JoinThread(mt);
        joinThread.start();
        for (int i = 0; i<10; i++){
            System.err.println("Main thread");
            try{
                joinThread.join();
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
        }
    }

    public static void dead_lock_condition2(){

        for (int i = 0; i<10; i++){
            System.err.println("Main thread");
            try{
                Thread.currentThread().join();
            }catch (InterruptedException e){

            }
        }
    }

}
