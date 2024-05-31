package LabSession5.App3;

import java.util.concurrent.CountDownLatch;

public class Fir1 extends Thread{
    int activity_min;
    int activity_max;
    int sleep_min;
    int sleep_max;
    boolean isReady = false;
    Integer monitor1;
    Integer monitor2;
    CountDownLatch countDownLatch;

    Fir1(int activity_min, int activity_max, int sleep_min, int sleep_max, Integer monitor1, Integer monitor2, CountDownLatch countDownLatch){
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min) * 500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 1");

        int k1 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

        System.out.println(this.getName() + " Activity for " + k1);

        for (int i = 0; i < k1 * 100000; i++) {
            i++;
            i--;
        }

        synchronized (monitor1){
            System.out.println(this.getName() + " send notify");
            monitor1.notifyAll();
        }

        synchronized (monitor2){
            System.out.println(this.getName() + " send notify");
            monitor2.notifyAll();
        }

        System.out.println(this.getName() + " - STATE 2");

        countDownLatch.countDown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
