public class Test4 extends Thread{
    public void start(){
        System.out.println("Start method");
    }

    public void run()
    {
        System.out.println("run method");
    }

    public static void main(String[] args) {
        Test4 t4 = new Test4();
        Test4 t5 = new Test4();

        t4.start();
        t5.start();
    }
}
