package LabSession5.App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Fir extends Thread{
    public int[] activity_min;
    public int[] activity_max;
    public int sleep_min;
    public int sleep_max;
    public Semaphore semaphore1;
    public Semaphore semaphore2;
    public CyclicBarrier barrier;

    public Fir(int[] activity_min, int[] activity_max, int sleep_min, int sleep_max, Semaphore semaphore1, Semaphore semaphore2, CyclicBarrier barrier){
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(this.getName() + "-State 1");
            int k1 = (int) Math.round(Math.random() * (activity_max[0]-activity_min[0]) + activity_min[0]);
            for (int i = 0; i < k1 * 100000; i++){
                i++;
                i--;
            }

        try {
            if(semaphore1.tryAcquire(1,1, TimeUnit.SECONDS)){
                System.out.println(this.getName() + "-State 2");
                int k2 = (int) Math.round(Math.random() * (activity_max[1]-activity_min[1]) + activity_min[1]);
                for (int i = 0; i < k1 * 100000; i++){
                    i++;
                    i--;
                }

                semaphore1.release(1);
            }
            else {
                System.out.println("Semaphore 1 is not available!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            if(semaphore2.tryAcquire(1, 1, TimeUnit.SECONDS)){
                    System.out.println(this.getName() + "-State 3");
                    try {
                        Thread.sleep(sleep_min * 500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    semaphore2.release(1);

                }else {
                    System.out.println("Semaphore 2 is not available!");
                }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + "-State 4");

        try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
