package LabSession4.Lab5.Lab7App4;

import java.util.concurrent.Semaphore;

public class Fir extends Thread{
    Semaphore s;
    int[] activityMin;
    int[] activityMax;
    int[] sleepMin;
    int[] sleepMax;

    public Fir(Semaphore s, int[] activityMin, int[] activityMax, int[] sleepMin, int[] sleepMax){
        this.s = s;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.s.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 1");
            int k1 = (int) Math.round(Math.random() * (activityMax[0]-activityMin[0]) + activityMin[0]);

            for (int i = 0; i < k1 * 100000; i++){
                i++;
                i--;
            }

            this.s.release(1);

            System.out.println(this.getName() + " - STATE 2");

            try{
                Thread.sleep(Math.round(Math.random() * (sleepMax[0]-sleepMin[0]) + sleepMin[0])*500);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 3");
        }
    }
}
