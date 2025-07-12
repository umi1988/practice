package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample2
{
    public static void main(String[] args) {
        int numberOfSystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSystems, new Runnable() {
            @Override
            public void run() {
                System.out.println("All systems are up and running. System startup complete.");
            }
        });
        Thread webServerThread = new Thread(new Subsystem("Web Server" , 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("DataBase" , 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem("Cache" , 3000, barrier));
        Thread messagingServiceThread = new Thread(new Subsystem("Messaging Service" , 3500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();
    }
}

class Subsystem implements  Runnable{

    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    public Subsystem(String name, int i, CyclicBarrier barrier) {
        this.name=name;
        this.initializationTime=i;
        this.barrier=barrier;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " Initialization started. ");
            Thread.sleep(initializationTime);// simulate time taken to initialize
            System.out.println(name + " Initialization complete. ");
            barrier.await();
        }catch (Exception e){

        }
    }
}
