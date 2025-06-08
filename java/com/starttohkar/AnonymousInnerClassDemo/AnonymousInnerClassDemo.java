package com.starttohkar.AnonymousInnerClassDemo;

class AnonymousInnerClass{
    public  void show(){
        System.out.println("In  AnnoynomousInnerClass show() method");
    }
}

// I don't want to create a separate class since we are we need to new implemenation of show method only once, so we will use anonymous class
/*class AnonymousInnerClass1 extends AnonymousInnerClass{
    public  void show(){
        System.out.println("In AnonymousInnerClass1 show() method");
    }
}
    */

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        AnonymousInnerClass an = new AnonymousInnerClass(){
            public void show(){
                System.out.println("in anonymous inner class show() method");
            }
        };
        an.show();
    }
}

