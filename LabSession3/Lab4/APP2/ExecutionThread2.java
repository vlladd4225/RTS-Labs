package LabSession3.Lab4.APP2;

public class ExecutionThread2 extends Thread{
    Integer firstMonitor;
    Integer secondMonitor;
    int[] activityMin;
    int[] activityMax;
    int[] sleepMin;
    int[] sleepMax;

    ExecutionThread2(Integer firstMonitor, Integer secondMonitor, int[] activityMin, int[] activityMax, int[] sleepMin, int[] sleepMax){
        this.firstMonitor = firstMonitor;
        this.secondMonitor = secondMonitor;
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
        synchronized (firstMonitor){
            System.out.println(this.getName() + " - STATE 2");
            int k2 = (int) Math.round(Math.random() * (activityMax[1]-activityMin[1]) + activityMin[1]);

            for (int i = 0; i < k2 * 100000; i++) {
                i++;
                i--;
            }
        }

        synchronized (secondMonitor) {
            System.out.println(this.getName() + " - STATE 3");
            try{
                Thread.sleep(Math.round(Math.random() * (sleepMax[0]-sleepMin[0]) + sleepMin[0])*500);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

        System.out.println(this.getName() + " - STATE 4");
    }
}
