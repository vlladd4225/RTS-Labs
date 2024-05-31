package LabSession3.Lab4.APP4;

public class App4 {
    @SuppressWarnings("removal")
    public static void main(String[] args) throws InterruptedException {

        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);

        ExecutionThread4 thread4 = new ExecutionThread4(2, 3, 7, 7, monitor1, monitor2);
        ExecutionThread5 thread51 = new ExecutionThread5(3, 5, thread4, monitor1);
        ExecutionThread5 thread52 = new ExecutionThread5(4, 6, thread4, monitor2);

        thread4.start();
        thread51.start();
        thread52.start();
    }
}
