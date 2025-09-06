package yield;

public class YieldThreadDemo {
    public static void main(String[] args){
        // yield : it pauses current thread execution to give chance to other waiting thread having
        // same priority. it only stops the execution of current thread,
        // if there is waiting thread of same priority.
        // this is native method and also static (native methods are those, which have native keyword and not written in other languages like C or C++
        yield_implementation();
        // in above method if we comment Thread.yield() then we can't predict the output,
        // but not then there is heigh possibility that child thread end last.
    }

    public static void yield_implementation(){
        YieldThread yieldThread = new YieldThread();
        yieldThread.start();
        for (int i = 0; i< 10; i++){
            System.err.println("Main thread");
        }
    }
}
