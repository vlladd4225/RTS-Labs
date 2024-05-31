package LabSession3.Lab4.APP4;

public class ExecutionThread4 extends Thread{
    int activity_min;
    int activity_max;
    int sleep_min;
    int sleep_max;
    boolean isReady = false;
    Integer monitor1;
    Integer monitor2;
    ExecutionThread4(int activity_min, int activity_max, int sleep_min, int sleep_max, Integer monitor1, Integer monitor2){
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
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
    }
}
