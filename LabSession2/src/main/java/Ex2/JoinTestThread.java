package Ex2;

public class JoinTestThread extends Thread{
    public static int sum = 0;
    public Thread thread;

    int number = 60000;
    int localSum = 0;
    public JoinTestThread(String name, Thread thread) {
        this.thread = thread;
        this.setName(name);
    }
    public void run() {
        System.out.println("Thread" + this.getName() + " has entered the run() method");
        try {
            if (thread != null) thread.join();
            System.out.println("Thread " + this.getName() + " executing operation.");
            for (int i = 1; i <= this.number; i++) {
                if (this.number % i == 0) {
                    this.localSum += i;
                }
            }
            synchronized(this) {
                JoinTestThread.sum += this.localSum;
            }
            System.out.println("Thread " + this.getName() + " has terminated operation, with value: " + Integer.toString(JoinTestThread.sum));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
