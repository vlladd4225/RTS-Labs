package LabSession3.Lab4.APP3;

public class ExecutionThread3 extends Thread{
    Integer firstMonitor;
    int[] activityMin;
    int[] activityMax;
    int[] sleepMin;
    int[] sleepMax;

    ExecutionThread3(Integer firstMonitor, int[] activityMin, int[] activityMax, int[] sleepMin, int[] sleepMax){
        this.firstMonitor = firstMonitor;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
    }

    @Override
    public void run() {
        while (true){
            synchronized (firstMonitor){
                System.out.println(this.getName() + " - STATE 1");
                int k1 = (int) Math.round(Math.random() * (activityMax[0]-activityMin[0]) + activityMin[0]);

                for (int i = 0; i < k1 * 100000; i++){
                    i++;
                    i--;
                }
                System.out.println(this.getName() + " monitor released!");
            }

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
