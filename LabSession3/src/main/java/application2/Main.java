package application2;

import application1.ExecutionThread;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String []args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);

        new application2.ExecutionThread(monitor1, 2, 4, 4).start();
        new application2.ExecutionThread(monitor2, 2, 5, 5).start();
        new application2.ExecutionThreadSpecial(monitor1, monitor2, 3, 6, 3).start();
    }
}
