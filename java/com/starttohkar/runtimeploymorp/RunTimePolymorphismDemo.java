package com.starttohkar.runtimeploymorp;
/**
 * Dynamic method dispatch -- Runtime Polymorphism
 *
 *
 */
class AA{
    public void show()
    {
        System.out.println("in AA show() method");
    }
}

class BB extends AA{
    public void show()
    {
        System.out.println("in BB show() method");
    }
}

class CC extends BB{
    public void show()
    {
        System.out.println("in CC show() method");
    }
}

public class RunTimePolymorphismDemo {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.show();

        aa = new BB();
        aa.show();

        aa = new CC();
        aa.show();
    }
}
