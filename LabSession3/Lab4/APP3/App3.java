package LabSession3.Lab4.APP3;

public class App3 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        Integer monitor = new Integer(1);

        new ExecutionThread3(monitor, new int[]{4}, new int[]{7}, new int[]{3}, new int[]{3}).start();
        new ExecutionThread3(monitor, new int[]{5}, new int[]{7}, new int[]{6}, new int[]{6}).start();
        new ExecutionThread3(monitor, new int[]{3}, new int[]{6}, new int[]{5}, new int[]{5}).start();
    }
}
