package LabSession5.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Fir extends Thread {
    ReentrantLock firstLock;
    ReentrantLock secondLock;
    int sleep_min;
    int sleep_max;
    int activity_min;
    int activity_max;
    CountDownLatch countDownLatch;

    public Fir(ReentrantLock firstMonitor, ReentrantLock secondMonitor, int sleep_min, int sleep_max, int activity_min, int activity_max, CountDownLatch countDownLatch){
        this.firstLock = firstMonitor;
        this.secondLock = secondMonitor;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(this.getName() + " - STATE 1");

            if(firstLock != null && secondLock != null){
                this.firstLock.lock();
                this.secondLock.lock();
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++){
                    i++;
                    i--;
                }
                try{
                    Thread.sleep(Math.round(Math.random() * (sleep_max-sleep_min) + sleep_min)*500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                this.firstLock.unlock();
                this.secondLock.unlock();
            }
            else if(firstLock != null){
                firstLock.lock();
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++){
                    i++;
                    i--;
                }
                try{
                    Thread.sleep(Math.round(Math.random() * (sleep_max-sleep_min) + sleep_min)*500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                firstLock.unlock();
            }
            else if (secondLock != null){
                secondLock.lock();
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++){
                    i++;
                    i--;
                }
                try{
                    Thread.sleep(Math.round(Math.random() * (sleep_max-sleep_min) + sleep_min)*500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                secondLock.unlock();
            }

            System.out.println(this.getName() + " - STATE 3");

            countDownLatch.countDown();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

