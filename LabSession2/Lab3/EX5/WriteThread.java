package LabSession2.Lab3.EX5;

import java.io.PipedOutputStream;

public class WriteThread extends Thread{
    private PipedOutputStream pipedOutputStream;

    WriteThread(){
        pipedOutputStream = new PipedOutputStream();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int d = (int) (10 * Math.random());
                System.out.println("Writing Thread is sent: " + d);
                pipedOutputStream.write(d);
                sleep(400);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    PipedOutputStream getPipe() {
        return this.pipedOutputStream;
    }
}
