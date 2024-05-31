package application1;

public class ExecutionThread extends Thread{
    Integer monitor;
    int sleepMin;
    int sleepMax;
    int activityMin;
    int activityMax;

    public ExecutionThread(Integer monitor, int sleepMin, int sleepMax, int activityMin, int activityMax) {
        this.monitor = monitor;
        this.sleepMax = sleepMax;
        this.sleepMin = sleepMin;
        this.activityMax = activityMax;
        this.activityMin = activityMin;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1 ");
        try {
            Thread.sleep(Math.round(Math.random() * (sleepMax - sleepMin) + sleepMin) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2 ");
        synchronized (monitor) {
            System.out.println(this.getName() + " - STATE 3 ");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 4");
        }

    }
}
