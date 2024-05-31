package LabSession2.Lab3.APP1;

import java.io.*;
import java.util.Date;

public class FileService extends Thread{
    String fileName;
    BufferedReader in;
    PrintWriter out;

    public FileService(String fileName, String name){
        this.fileName = fileName;

        try {
            this.out = new PrintWriter(new FileWriter(fileName, true));
            this.in = new BufferedReader(new FileReader(fileName));
        } catch (Exception ex){
            ex.printStackTrace();
        }

        this.setName(name);
    }

    @Override
    public void run() {
        while(!App1.isStopThread()){
            synchronized (this){
                if(currentThread().getName().equals("Write")){
                    Date date = new Date(System.currentTimeMillis());
                    this.out.println("Date: " + date);
                    this.out.println("Message: " + String.valueOf(Math.random() * 100));
                    this.out.flush();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (currentThread().getName().equals("Read")){
                    String iterator;
                    String last = "no message to read";
                    while (true){
                        try {
                            if ((iterator = in.readLine()) == null) break;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        last = new Date(System.currentTimeMillis()) + " - " + iterator;
                    }
                    System.out.println(last);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
