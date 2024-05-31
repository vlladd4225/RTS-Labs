package LabSession2.Lab3.EX1;

public class RThread extends Thread{
    FileService service;

    public RThread(FileService service){
        this.service = service;
    }

    @Override
    public void run() {
        while(!Exercise1.isStopThread()){
            try{
                String readMsg = service.read();
                System.out.println(readMsg);
                Thread.sleep(3000);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
