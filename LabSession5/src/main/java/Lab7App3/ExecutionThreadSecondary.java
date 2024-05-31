package Lab7App3;

import java.util.concurrent.CountDownLatch;

public class ExecutionThreadSecondary extends Thread{
    int delay;
    int minActivity;
    int maxActivity;
    Object P6;
    CountDownLatch T11;

    public ExecutionThreadSecondary(int minActivity, int maxActivity, int delay, Object P6, CountDownLatch T11) {
        this.delay = delay;
        this.minActivity = minActivity;
        this.maxActivity = maxActivity;
        this.P6 = P6;
        this.T11 = T11;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (P6) {
            try {
                P6.wait();
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

        T11.countDown();
        try {
            T11.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
