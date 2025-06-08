public class ThreadYieldMethodDemo extends Thread{
    public ThreadYieldMethodDemo(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " -- is running ... ");
            Thread.yield(); // this method will hint to schedule to give chance to other scheduler even though my execution are not yet finished
        }
    }

    public static void main(String[] args) {
        ThreadYieldMethodDemo t1 = new ThreadYieldMethodDemo("T1");
        ThreadYieldMethodDemo t2 = new ThreadYieldMethodDemo("T2");
        t1.start();
        t2.start();
    }
    
}
