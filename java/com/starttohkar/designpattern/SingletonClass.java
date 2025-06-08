package com.starttohkar.designpattern;

public class SingletonClass
{
    //static variable to hold the single instance
    private static volatile SingletonClass instance;

    //private constructor to prevent instantiation
    private SingletonClass(){
        if(instance != null)// reflection scenario covered
        {
            //runtime exception
        }
        System.out.println("Singleton instance created");
    }

    //serialization
    protected Object readResolve(){
        return getInstance();
    }


    //cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Cloning not supported");
    }

    //static method to get the single instance
    public static SingletonClass getInstance(){
        // lazy instantiation -- no recommanded for multithreaded env
        /*if(instance == null){
            System.out.println("creating first instance");
            instance = new com.starttohkar.designpattern.SingletonClass();
        }*/


        // double-checked locking
        if(instance == null){
            synchronized (SingletonClass.class){ // thread safe
                if (instance == null){
                    System.out.println("creating first instance");
                    instance = new SingletonClass();
                }
            }
        }
        System.out.println("fetching instance");
        return instance;
    }
}
