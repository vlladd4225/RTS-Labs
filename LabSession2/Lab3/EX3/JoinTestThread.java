package LabSession2.Lab3.EX3;

public class JoinTestThread extends Thread{
    Thread t;
    int no;

    JoinTestThread(String n, Thread t, int no){
        this.setName(n);
        this.t = t;
        this.no = no;
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " has entered the run() method");

        try{
            if (t != null){
                t.join();
            }
            System.out.println("Thread " + getName() + " executing operations");
            sumDiv();
            System.out.println("The sum is equal to " + Exercise3.sumDiv + " obtained by " + getName());
            System.out.println(getName() + " has terminated operation");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void sumDiv(){
        int sum = 0;

        for (int i = 1; i < this.no / 2; i++){

            if (this.no % i == 0){
                sum += i;
            }
        }

        sum += this.no;
        Exercise3.sumDiv = sum;
    }
}
