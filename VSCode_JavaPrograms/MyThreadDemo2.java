
public class MyThreadDemo2 extends Thread{
    public MyThreadDemo2(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + Thread.currentThread().getPriority() + " -- count " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public static void main(String[] args) {
        MyThreadDemo2 t2 =  new MyThreadDemo2("Umesh Thread Low");
        MyThreadDemo2 t3 =  new MyThreadDemo2("Umesh Thread High");
        MyThreadDemo2 t4 =  new MyThreadDemo2("Umesh Thread Medium");
        
        t2.setPriority(MIN_PRIORITY);
        t3.setPriority(MAX_PRIORITY);
        t4.setPriority(NORM_PRIORITY);

        t2.start();
        t3.start();
        t4.start();
    
    }
    
}
