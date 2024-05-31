package LabSession4.Lab5.Lab7App4;

import java.util.concurrent.Semaphore;

public class Lab7App4 extends Thread{
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);

        new Fir(s, new int[]{4}, new int[]{7}, new int[]{3}, new int[]{3}).start();
        new Fir(s, new int[]{5}, new int[]{7}, new int[]{6}, new int[]{6}).start();
        new Fir(s, new int[]{3}, new int[]{6}, new int[]{5}, new int[]{5}).start();
    }
}
