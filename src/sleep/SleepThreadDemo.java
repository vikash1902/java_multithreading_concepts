package sleep;

public class SleepThreadDemo {
    public static void main(String[] args){
        // sleep is called when a thread don't want to do any execution for some time
        // it gives InterruptedException which is a checked exception
        // it has one native method and overloaded one are not native method
        // constructor of sleep()
        // a) public static native void sleep(long millisecond);
        // b) public static void sleep(long millisecond, int nanosecond);
        sleep_implementation();

        // to interrupt a sleeping thread there is a interrupt();
        // the interrupt method work only if the thread on which we are calling interrupt is in waiting or sleeping state
        // if the target thread is in running state the interrupt call wait until it goes to waiting or sleeping state, if the target thread never goes to waiting or sleeping state in its life cycle than it is waisted
        interrupt_implementation();
    }

    public static void sleep_implementation(){
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
        for(int i = 0; i < 10; i++){
            System.err.println("Main Thread");
        }
        System.err.println("Main thread completes");
    }

    public static void interrupt_implementation(){
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
        sleepThread.interrupt();
        for(int i = 0; i < 10; i++){
            System.err.println("Main Thread");
        }
        System.err.println("Main thread completes");
    }
}
