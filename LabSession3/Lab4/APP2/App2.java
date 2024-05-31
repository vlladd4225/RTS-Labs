package LabSession3.Lab4.APP2;

public class App2 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Integer firstMonitor = new Integer(1);
        Integer secondMonitor = new Integer(2);

        new ExecutionThread2(firstMonitor, secondMonitor, new int[]{2, 4}, new int[]{4, 6}, new int[]{4}, new int[]{4}).start();
        new ExecutionThread2(secondMonitor, firstMonitor, new int[]{3, 5}, new int[]{5, 7}, new int[]{5}, new int[]{5}).start();
    }
}
