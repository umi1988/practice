package com.hackerrank.solution;

import java.util.ArrayList;
import java.util.List;

public class PlusMinusProblem {
    public static void plusMinus(List<Integer> arr) {
        int plusNums = 0, minusNums = 0, zeroNums = 0;
        double arrSize = arr.size();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                plusNums++;
            } else if (arr.get(i) < 0) {
                minusNums++;
            } else {
                zeroNums++;
            }
        }

        System.out.printf("%.6f%n", plusNums / arrSize);
        System.out.printf("%.6f%n", minusNums / arrSize);
        System.out.printf("%.6f%n", zeroNums / arrSize);
    }

    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<>();
        listOfInteger.add(-4);
        listOfInteger.add(3);
        listOfInteger.add(-9);
        listOfInteger.add(0);
        listOfInteger.add(4);
        listOfInteger.add(1);

        plusMinus(listOfInteger);




    }
}
