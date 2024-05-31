package LabSession3.Lab4.APP4;

public class ExecutionThread5 extends Thread{
    int activity_min;
    int activity_max;
    ExecutionThread4 thread4;
    Integer monitor;

    ExecutionThread5(int activity_min, int activity_max, ExecutionThread4 thread4, Integer monitor) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.thread4 = thread4;
        this.monitor = monitor;
    }

    @Override
    public void run() {

        synchronized (monitor){
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(this.getName() + " - STATE 1");

        int k1 = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);
        System.out.println(this.getName() + " Activity for " + k1);

        for (int i = 0; i < k1 * 100000; i++){
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 2");

        try {
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
