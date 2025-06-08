public class ThreadSetDeamonMethodDemo extends Thread {
    public ThreadSetDeamonMethodDemo(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println("hello world...");   
        }
    }
    
    public static void main(String[] args) {// main thread
        ThreadSetDeamonMethodDemo t1 = new ThreadSetDeamonMethodDemo("T1"); // User Thread
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main Thread...Finish");
    }    

    // Daemon thread are back ground threads which run in the background and jvm won't wait for them to finish.
}
