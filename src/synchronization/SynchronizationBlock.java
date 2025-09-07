package synchronization;

public class SynchronizationBlock extends Thread{
    Display display;
    public SynchronizationBlock(Display display){
        this.display = display;
    }

    public void run(){
        display.synchronized_block_using_this();
        display.synchronized_block_using_object();
        display.synchronized_block_using_class_level_lock();
    }
}
