class Test1 implements  Runnable{ 
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test2 implements  Runnable{ 
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
    }
}


public class ThreadDemo1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        Test2 t2 = new Test2();

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        //t2.setPriority(Thread.MAX_PRIORITY);

        th1.start();
        th2.start();

    }
}
