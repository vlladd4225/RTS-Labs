package LabSession4.Lab5.App2;

import java.util.concurrent.Semaphore;

public class ExampleSemaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(4);
        Fir f1 = new Fir(1, s, 2, (int) Math.round(Math.random() * 3 + 2), 2);
        Fir f2 = new Fir(2, s, 4, (int) Math.round(Math.random() * 3 + 3), 2);
        f1.start();
        f2.start();
    }
}
