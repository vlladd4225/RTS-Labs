package LabSession2.Lab3.EX1;

import java.io.*;
import java.util.Date;

public class FileService {
    String fileName;
    BufferedReader in;
    PrintWriter out;

    public FileService(String fileName){
        this.fileName = fileName;

        try {
            this.out = new PrintWriter(new FileWriter(fileName, true));
            this.in = new BufferedReader(new FileReader(fileName));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public synchronized void write(String msg) {
        Date date = new Date(System.currentTimeMillis());
        this.out.println("Date: " + date);
        this.out.println("Message: " + msg);
        this.out.flush();
    }

    public synchronized String read() throws IOException {
        String iterator;
        String last = "no message to read";
        while ((iterator = in.readLine()) != null){
            last = new Date(System.currentTimeMillis()) + " - " + iterator;
        }
        return last;
    }
}
