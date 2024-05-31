package LabSession2.Lab3.EX1;

public class WThread extends Thread{
    FileService service;

    public WThread(FileService service){
        this.service = service;
    }

    @Override
    public void run(){
        while(!Exercise1.isStopThread()){
            String msg = String.valueOf(Math.random() * 100);
            service.write(msg);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
