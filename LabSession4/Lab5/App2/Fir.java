package LabSession4.Lab5.App2;

import java.util.concurrent.Semaphore;

public class Fir extends Thread{
    int delay, permit, k, name;
    Semaphore s;

    public Fir(int name, Semaphore s, int delay, int k, int permit){
        this.name = name;
        this.s = s;
        this.k = k;
        this.delay = delay;
        this.permit = permit;
    }

    public void run(){
        while(true){
            System.out.println("Fir " + name +" State 1");

            try {
                Thread.sleep(this.delay * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Fir " + name +" State 2");

            try {
                this.s.acquire(this.permit); // critical region
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Fir " + this.name + " took a token from the semaphore");
            System.out.println("Fir " + name +" State 3");

            for (int i = 0; i < this.k * 100000; i++) {
                i++;
                i--;
            }

            this.s.release(this.permit);

            System.out.println("Fir " + this.name + " released a token from the semaphore");
            System.out.println("Fir " + this.name + " state 4");
        }
    }
}
