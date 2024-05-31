package LabSession5.App3;

import java.util.concurrent.CountDownLatch;

public class App3 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);

        Fir1 thread1 = new Fir1(2, 3, 7, 7, monitor1, monitor2, countDownLatch);
        Fir2 thread21 = new Fir2(3, 5, thread1, monitor1, countDownLatch);
        Fir2 thread22 = new Fir2(4, 6, thread1, monitor2, countDownLatch);

        thread1.start();
        thread21.start();
        thread22.start();
    }
}
