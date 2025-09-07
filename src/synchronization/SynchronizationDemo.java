package synchronization;

public class SynchronizationDemo {

    public static void main(String[] args){
        // When multiple thread work on same object causing data inconsistency this is known as Race Condition
        // to avoid Race condition we should use synchronization.
        // Synchronization is the process of allowing a single thread to work on an object at a same time. which is allowed to avoid race condition
        // Synchronization can be used by using Synchronized key word on method or block.
        // There are only synchronized block or synchronized method (not synchronized class)
        // in java or implementation of synchronization it usages concept of (Locks) there are two types of lock
        // a) class level lock
        // b) object level lock

//        synchronization_implementation();
        // in above implementation if single object is used by threads than only synchronization is required
        // is multiple object is used than synchronization is not required

        // is lock of object is acquired by one thread than other thread are not able to access other instance synchronized method
//        synchronization_implementation1();

        // but multiple thread can access not synchronized method of an object
//        synchronization_implementation2();

        // Synchronized block: it is block of code which is synchronized, suppose if there is 5 lines of code which require
        // synchronization, but we are using synchronization on method than it is not efficient it is time taking and performance issues
        // we can define synchronized block by three ways:
        // a) by taking lock of current object
        // b) by taking lock of any given object
        // c) by taking class level lock
        synchronization_block_implementation();
        // A thread can have multiple lock simultaneously YES
    }

    public static void synchronization_implementation(){
        // same display object is used by multiple thread synchronization will work here because same object is used
        // regular output will come
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Vikas");
        MyThread t2 = new MyThread(d, "Mishra");
        t1.start();
        t2.start();

        // different display is used by thread here synchronization will not work
        // irregular output will come
        Display d1 = new Display();
        Display d2 = new Display();
        MyThread t3 = new MyThread(d1, "Vikas");
        MyThread t4 = new MyThread(d2, "Mishra");
        t3.start();
        t4.start();
        System.err.println("End of main thread");
    }

    public static void synchronization_implementation1(){
        // only one thread will work on object lock at a time hence there is regular output
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Vikas");
        MyThread1 t2 = new MyThread1(d, 10);
        t1.start();
        t2.start();
        System.err.println("End of main thread");
    }

    public static void synchronization_implementation2(){
        // only one thread will work on object lock at a time hence
        // but multiple thread work simultaneously on non-synchronized method because each class has two area synchronized area and non-synchronized area hence this will give irregular output
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Vikas");
        MyThread1 t2 = new MyThread1(d, 10);
        MyThread3 t3 = new MyThread3(d);
        t1.start();
        t2.start();
        t3.start();
        System.err.println("End of main thread");
    }

    public static void synchronization_block_implementation(){
        Display display = new Display();
        SynchronizationBlock synchronizationBlock = new SynchronizationBlock(display);
        synchronizationBlock.start();
        System.err.println("End of main thread");
    }

}
