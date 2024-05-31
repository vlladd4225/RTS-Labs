package LabSession4.Lab5.ExampleLock;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread{
    int name;
    Lock l;

    public Fir(int name, Lock l){
        this.name = name;
        this.l = l;
    }

    @Override
    public void run() {
        System.out.println(this.name + " entered execution");
        this.l.lock();
        System.out.println("This thread " + this.name + " acquired lock");
        criticalRegion();
        this.l.unlock();
        System.out.println("This thread " + this.name + " released lock");
    }

    public void criticalRegion(){
        System.out.println("Executing critical region");
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
