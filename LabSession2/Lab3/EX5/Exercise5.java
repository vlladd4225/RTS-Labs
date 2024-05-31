package LabSession2.Lab3.EX5;

public class Exercise5 {
    public static void main(String[] args) {
        ReadThread readThread = new ReadThread();
        WriteThread writeThread = new WriteThread();

        try {
            readThread.connect(writeThread.getPipe());
            readThread.start();
            writeThread.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
