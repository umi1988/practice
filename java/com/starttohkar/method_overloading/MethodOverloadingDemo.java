package com.starttohkar.method_overloading;

class Cal{
    public int add(int i , int j){
        return i+j;
    }
    public int add(int i , int j, int k){
        return i+j+k;
    }
    public double add(double i , double j){
        return i+j;
    }
}

public class MethodOverloadingDemo
{
    public static void main(String[] args) {
        Cal cal = new Cal();
        int r1 =  cal.add(1,2);
        int r2 = cal.add(1,2,3);
        double d =  cal.add(2.3,4.6);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(d);
    }
}
