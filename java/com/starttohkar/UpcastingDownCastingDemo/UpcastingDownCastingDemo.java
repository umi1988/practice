package com.starttohkar.UpcastingDownCastingDemo;


class AAA{
    public void show1(){
        System.out.println("in AAA show1()");
    }
}

class BBB extends AAA{
    public void show2(){
        System.out.println("in BBB show2()");
    }
}
class UpcastingDownCastingDemo{
    public static void main(String[] args) {
        // upcasting - it happens implicitely
        AAA a = new BBB();
        a.show1();

        BBB b = (BBB)a;// downcasting to a object to refer b - we need to do it manually
        b.show2();

    }
}

