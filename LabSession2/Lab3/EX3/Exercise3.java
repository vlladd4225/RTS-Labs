package LabSession2.Lab3.EX3;

public class Exercise3 {

    public static long sumDiv = 0;
    public static void main(String[] args) {
        JoinTestThread t1 = new JoinTestThread("Thread 1", null, 56200);
        JoinTestThread t2 = new JoinTestThread("Thread 2", t1, 25400);
        t1.start();
        t2.start();
    }
}
