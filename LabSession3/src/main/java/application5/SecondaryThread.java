package application5;

public class SecondaryThread extends Thread {
    int delay;
    int minActivity;
    int maxActivity;
    Object monitor;
    MainThread t1;
    public SecondaryThread(int minActivity, int maxActivity, int delay, Object monitor, MainThread t1) {
        this.delay = delay;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.monitor = monitor;
        this.t1 = t1;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (this.maxActivity - this.minActivity) + this.minActivity);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName() + " - STATE 3");
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
