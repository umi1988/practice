public class ThreadJoinMethodDemo extends Thread{

    @Override
    public void run() {
            try{
                Thread.sleep(10000);
                System.out.println("Thread is running...");
            }catch(InterruptedException e){
                System.out.println("Thread Interrupted..." + e);
            }
        }

    public static void main(String[] args) throws InterruptedException {
       ThreadJoinMethodDemo t1 = new ThreadJoinMethodDemo();
       t1.start(); 
       t1.join(); // this method means caller thread that is main thread will wait for t1 thread to finish then only main thread will proceed
       // now this below statement Hello will print after finishing t1 thread then only hello will print
       System.out.println("Hello...");
    }
}
