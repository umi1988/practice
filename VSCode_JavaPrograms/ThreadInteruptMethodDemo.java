class ThreadIntruptMethodDemo extends Thread{

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Thread is running...");
        }catch(InterruptedException e){
            System.out.println("Thread Interrupted..." + e);
        }
    }
    public static void main(String[] args) {
        ThreadIntruptMethodDemo t1 = new ThreadIntruptMethodDemo();
        t1.start();
        t1.interrupt(); // main thread  -> t1 thread needs to be stop/interrupt immediately.
        
    }
}