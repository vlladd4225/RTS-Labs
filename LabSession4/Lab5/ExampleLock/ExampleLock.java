package LabSession4.Lab5.ExampleLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleLock {
    public static void main(String[] args) {
        Lock l = new ReentrantLock();
        Fir f1 = new Fir(1, l);
        Fir f2 = new Fir(2, l);
        f1.start();
        f2.start();
    }
}
