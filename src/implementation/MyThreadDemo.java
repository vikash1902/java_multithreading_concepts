package implementation;

public class MyThreadDemo {

    public static void main(String[] args) {
        // Thread creation
           creating_thread();

        // case - 1 thread schedular
           thread_schedular();

        // case - 2 calling run method in place of start method
           calling_run();

        // case 3 importance of start method, start method is  responsible for creation of Thread because it has code for all the resources required for creating thread.

        // case 4 overloading of run() it is possible to overload run() but we call Thread.start() it call no-arg run() only
           overloaded_run();

        // if we don't override run method than what will happen the parent class(Thread) run method called which has empty implementation.

        // if we override start() than if we call thread.start() on object then no thread created because it called child's start method and no thread created it work as normal instance method.

        // if we call super.start() from overridden start() than parent's(Thread) start() called and thread created.
           overridden_start();

        // when a thread re-started it give an exception named IllegalThreadStateException
           thread_restarted();

        // Thread life-cycle (new/born) -> (ready/Runnable) --> (Running) --> (dead).

        // Thread priority, thread have minimum priority 1 and maximum priority 10 and default priority of 10.
        // if we enter any number which is not in range from 1 to 10 it gives run time exception IllegalArgumentException
        set_thread_priority();

    }

    public static void creating_thread() {
        // Creating thread using class Which has extended Thread Class
        MyThread1 t1 = new MyThread1();
        t1.start();

        //  Creating thread using class which has implemented runnable interface
        MyThread2 runnable = new MyThread2();
        Thread t2 = new Thread(runnable);
        t2.start();
    }

    public static void thread_schedular() {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        for (int i = 0; i < 10; i++) {
            System.err.println("Main thread --> " + i);
        }
        //  here we are not able to predict what is order of execution which is depended on Thread Schedular.
    }

    public static void calling_run(){
        MyThread1 myThread1 = new MyThread1();
        myThread1.run();
        for (int i = 0; i < 10; i++) {
            System.err.println("Main thread --> " + i);
        }
//        here the output will be child thread 10 times than main thread 10 times and both are executed by main thread itself
//        run method work as normal instance method
    }

    public static void overloaded_run(){
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
//        here the output will be the task written in run() not in run(int num)
    }

    public static void overridden_start(){
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
//      it will create thread because from start() we called super.start().
    }

    public static  void thread_restarted(){
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        System.err.println("Main thread");
        thread1.start();
    }

    public static void set_thread_priority(){
        MyThread1 thread1 = new MyThread1();
        for(int i = 0; i < 10 ; i++){
            System.err.println("Main Thread");
        }
        thread1.setPriority(10);
        thread1.setPriority(1);
        thread1.start();
        System.err.println("Main thread");
    }
}
