package application1;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String []args) {
        Integer monitor = new Integer(1);
        new ExecutionThread(monitor, 2, 4, 3, 6).start();
        new ExecutionThread(monitor, 3,5,4,7).start();
    }
}
