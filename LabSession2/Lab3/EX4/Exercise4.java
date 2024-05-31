package LabSession2.Lab3.EX4;

public class Exercise4 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Group of threads");
        ThreadEx threadEx1 = new ThreadEx(threadGroup, "Thread 1");
        ThreadEx threadEx2 = new ThreadEx(threadGroup, "Thread 2");
        ThreadEx threadEx3 = new ThreadEx(threadGroup, "Thread 3");

        threadEx1.start();
        threadEx2.start();
        threadEx3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadGroup.activeCount() + " Threads in group");

        Thread threads[] = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t.getName());
        }

        threadEx1.stopThread();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadGroup.activeCount() + " Threads in group");
        threadGroup.interrupt();
    }
}
