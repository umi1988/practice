package com.starttohkar.method_overriding;

class Calcu{
    public int add(int n1, int n2){
        return n1+n2;
    }

    public void config(){
        System.out.println("In config A method");
    }
}

class AdvCalcu extends Calcu{
    public int add(int n1, int n2){
        return n1+n2+1;
    }
}

public class MethodOverridingDemo {
    public static void main(String[] args) {
        Calcu c = new AdvCalcu();
        int res = c.add(1,2);
        c.config();
        System.out.println(res);
    }
}
