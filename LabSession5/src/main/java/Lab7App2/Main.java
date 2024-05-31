package Lab7App2;

import Lab7App1.ExecutionThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock P9 = new ReentrantLock();
        Lock P10 = new ReentrantLock();

        CountDownLatch T8 = new CountDownLatch(3);

        Lab7App2.ExecutionThread thread1 = new Lab7App2.ExecutionThread(P9, T8, 2, 4, 4);
        Lab7App2.ExecutionThread thread3 = new Lab7App2.ExecutionThread(P10, T8, 2, 5, 5);

        Lab7App2.ExecutionThreadMiddle thread2 = new Lab7App2.ExecutionThreadMiddle(P9, P10, T8, 3, 6, 3);

        System.out.println("P0");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
