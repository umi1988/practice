package com.starttohkar.super_keyword;

// in constructor we are we hv by default super method
// every constructor in java has a method super() by default

class A{
    public A(){
       // super();
        System.out.println("A cons -- ");
    }
    public A(int a){
        //super(a);
        System.out.println("A cons -- with int");
    }
}

class B extends A{
    public B(){
        super(9);
        System.out.println("B cons -- ");
    }
    public B(int a){
        super(a);
        System.out.println("B cons -- with int");
    }
}

public class SuperKeywordDemo {
    public static void main(String[] args) {
        A a = new B();

    }
}
