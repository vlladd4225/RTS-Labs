package LabSession2.Lab3.EX5;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ReadThread extends Thread{
    private PipedInputStream pipedInputStream;

    ReadThread() {
        pipedInputStream = new PipedInputStream();
    }

    @Override
    public void run() {
        try {
            while (true){
                if (pipedInputStream.available() > 0){
                    System.out.println("Read Thread is received: " + pipedInputStream.read());
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void connect(PipedOutputStream pipedOutputStream) throws Exception {
        pipedInputStream.connect(pipedOutputStream);
    }
}
