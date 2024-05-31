package LabSession3.Lab4.APP1;

public class ExecutionThread1 extends Thread{
    Integer firstMonitor;
    Integer secondMonitor;
    int sleep_min;
    int sleep_max;
    int activity_min;
    int activity_max;

    public ExecutionThread1(Integer firstMonitor, Integer secondMonitor, int sleep_min, int sleep_max, int activity_min, int activity_max){
        this.firstMonitor = firstMonitor;
        this.secondMonitor = secondMonitor;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        if(firstMonitor != null && secondMonitor != null){
            synchronized (firstMonitor){
                synchronized (secondMonitor){
                    System.out.println(this.getName() + " - STATE 2");
                    int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);

                    for (int i = 0; i < k * 100000; i++){
                        i++;
                        i--;
                    }
                }
                try{
                    Thread.sleep(Math.round(Math.random() * (sleep_max-sleep_min) + sleep_min)*500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }

                System.out.println(this.getName() + " release monitor");
            }
        }
        else if(firstMonitor != null){
            synchronized (firstMonitor){
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++){
                    i++;
                    i--;
                }
                try{
                    Thread.sleep(Math.round(Math.random() * (sleep_max-sleep_min) + sleep_min)*500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }

                System.out.println(this.getName() + " release monitor");
            }
        }
        else if (secondMonitor != null){
            synchronized (secondMonitor) {
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++){
                    i++;
                    i--;
                }
                try{
                    Thread.sleep(Math.round(Math.random() * (sleep_max-sleep_min) + sleep_min)*500);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }

                System.out.println(this.getName() + " release monitor");
            }
        }

        System.out.println(this.getName() + " - STATE 3");
    }
}
