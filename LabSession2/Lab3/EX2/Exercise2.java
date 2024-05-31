package LabSession2.Lab3.EX2;

public class Exercise2 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
