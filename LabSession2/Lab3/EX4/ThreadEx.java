package LabSession2.Lab3.EX4;

public class ThreadEx extends Thread{
    boolean stop;

    ThreadEx(ThreadGroup threadGroup, String name){
        super(threadGroup, name);
        this.stop = false;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ON");

        try{
            for (int i = 1; i < 1000; i++){
                System.out.println(".");
                Thread.sleep(250);

                synchronized (this){
                    if (stop){
                        break;
                    }
                }
            }
        }catch (Exception ex){
            System.out.println(Thread.currentThread().getName() + " interrupt");
        }

        System.out.println(Thread.currentThread().getName() + " ended");
    }

    public void stopThread() {
        this.stop = true;
    }
}
