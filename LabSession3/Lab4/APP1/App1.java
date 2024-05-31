package LabSession3.Lab4.APP1;

public class App1 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Integer firstMonitor = new Integer(1);
        Integer secondMonitor = new Integer(2);

        new ExecutionThread1(firstMonitor, null, 4, 4, 2, 4).start();
        new ExecutionThread1(firstMonitor, secondMonitor, 3 , 3, 3, 6).start();
        new ExecutionThread1(null, secondMonitor, 5, 5, 2, 5).start();
    }
}
