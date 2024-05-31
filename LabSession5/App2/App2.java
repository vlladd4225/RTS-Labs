package LabSession5.App2;

import LabSession3.Lab4.APP1.ExecutionThread1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class App2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ReentrantLock firstLock = new ReentrantLock();
        ReentrantLock secondLock = new ReentrantLock();

        new Fir(firstLock, null, 4, 4, 2, 4, countDownLatch).start();
        new Fir(firstLock, secondLock, 3 , 3, 3, 6, countDownLatch).start();
        new Fir(null, secondLock, 5, 5, 2, 5, countDownLatch).start();
    }
}
