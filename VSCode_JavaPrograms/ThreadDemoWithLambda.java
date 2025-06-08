
/*class Test11 implements  Runnable{ 
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
    */

/*
class Test22 implements  Runnable{ 
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
    }
}
    */
    

public class ThreadDemoWithLambda {
    public static void main(String[] args) {
        Runnable t1 =  () ->{
                for (int i = 0; i < 10; i++) {
                    System.out.println("hi");
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
        };
        Runnable t2 = () ->
        {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello");
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
        };

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        //t2.setPriority(Thread.MAX_PRIORITY);

        th1.start();
        th2.start();

    }
}
