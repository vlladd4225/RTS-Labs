package LabSession3.Lab4.EX1;

public class Exercise1 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
        new ExecutionThread(monitor, 2, 4, 3, 6).start();
        new ExecutionThread(monitor, 3, 5, 4, 7).start();
    }
}
