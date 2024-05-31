package LabSession2.Lab3.EX2;

public class Producer implements Runnable {
    private Buffer bf;
    private Thread thread;

    public Producer (Buffer bf) {
        this.bf = bf;
    }

    public void start() {
        if (this.thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        while(true){
            bf.put(Math.random());
            System.out.println("Producer " + this.thread.getName() + " gave a task.");
            try {
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
