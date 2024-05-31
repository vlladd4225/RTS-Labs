package LabSession2.Lab3.APP1;

public class App1 {

    private static boolean stopThread = false;
    public static void main(String[] args) {
        FileService service1 = new FileService("messages1.txt", "Write");
        FileService service2 = new FileService("messages1.txt", "Read");

        service1.start();
        service2.start();
    }

    public static boolean isStopThread() {
        return stopThread;
    }
}
