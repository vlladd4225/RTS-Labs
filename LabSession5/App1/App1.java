package LabSession5.App1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class App1 {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Threads have reached barrier!");
            }
        });
        Fir f1 = new Fir(new int[]{2, 4}, new int[]{4, 6}, 4, 4, semaphore1, semaphore2, barrier);
        Fir f2 = new Fir(new int[]{3, 5}, new int[]{5, 7}, 5, 5, semaphore2, semaphore1, barrier);
        f1.start();
        f2.start();
    }
}
