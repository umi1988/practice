package com.hackerrank.solution;

public class StairCaseProblem
{
    public static void staircase(int n) {
       for(int i=0;i<n;i++){
           for(int j=0;j<n-i-1;j++){
               System.out.print(" ");
           }
           for(int j=0;j<=i;j++) {
               System.out.print("*");
           }
           System.out.println();
       }

    }

    public static void main(String[] args) {
        staircase(6);
    }
}
