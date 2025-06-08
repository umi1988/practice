package com.starttohkar.typecasting;

public class TypeCastingDemo
{
    public static void main(String[] args) {
        int a  = 127;
        byte b = (byte) a;
        System.out.println(b);

        float f = 5.6F;
        int i = (int) f;
        System.out.println(i);

        byte b1 = 10;
        byte b2 = 30;
        byte result = (byte) (b1*b2);
        int result1 = b1*b2; // This is type promotion
        System.out.println(result);
        System.out.println(result1);

        int i1 = 257;
        byte bb1 = (byte) i1;
        System.out.println(i1);
    }
}
