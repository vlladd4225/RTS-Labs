package Ex2;

public class Main {
    public static void main(String [] args) {
        JoinTestThread w1 = new JoinTestThread("Thread1", null);
        JoinTestThread w2 = new JoinTestThread("Thread2", w1);
        w1.start();
        w2.start();
    }
}
