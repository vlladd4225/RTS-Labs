package LabSession4.Lab5.AppLab4;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread{
    Lock l1;
    Lock l2;
    int[] activityMin;
    int[] activityMax;
    int[] sleepMin;
    int[] sleepMax;

    public Fir(Lock l1, Lock l2, int[] activityMin, int[] activityMax, int[] sleepMin, int[] sleepMax){
        this.l1 = l1;
        this.l2 = l2;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k1 = (int) Math.round(Math.random() * (activityMax[0]-activityMin[0]) + activityMin[0]);

        for (int i = 0; i < k1 * 100000; i++){
            i++;
            i--;
        }

        if(l1.tryLock()){
            try{
                System.out.println(this.getName() + " - STATE 2");
                int k2 = (int) Math.round(Math.random() * (activityMax[1]-activityMin[1]) + activityMin[1]);

                for (int i = 0; i < k2 * 100000; i++) {
                    i++;
                    i--;
                }

                if(l2.tryLock()){
                    try{
                        System.out.println(this.getName() + " - STATE 3");
                        Thread.sleep(Math.round(Math.random() * (sleepMax[0]-sleepMin[0]) + sleepMin[0])*500);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    finally {
                        l2.unlock();
                    }
                }

            } catch (Exception e){
                e.printStackTrace();
            }
            finally {
                l1.unlock();
            }
        }

        System.out.println(this.getName() + " - STATE 4");
    }
}
