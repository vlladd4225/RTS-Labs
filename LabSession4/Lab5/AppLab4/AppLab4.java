package LabSession4.Lab5.AppLab4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppLab4 {
    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        Fir f1 = new Fir(l1, l2, new int[]{2, 4}, new int[]{4, 6}, new int[]{4}, new int[]{4});
        Fir f2 = new Fir(l2, l1, new int[]{3, 5}, new int[]{5, 7}, new int[]{5}, new int[]{5});
        f1.start();
        f2.start();
    }
}
