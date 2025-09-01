package Java8_Conceptual_Examples.Streams_Examples;

import java.util.*;

public class Test_Get_Highest_Second_Salary_Java7
{
    public static void main(String[] args) {
        List<Integer> salaries = Arrays.asList(19000,20000,40000,5000,20100);
        Set<Integer> uniqueSalaries = new HashSet<Integer>(salaries);

        Integer max = Integer.MIN_VALUE;
        System.out.println(max);

        for (Integer i : uniqueSalaries){
            if(i > max)
                max = i;
        }
        System.out.println(max);

        Integer secondMax = Integer.MIN_VALUE;
        for (Integer i : uniqueSalaries){
            if(i>secondMax && i<max)
                secondMax = i;
        }

        System.out.println(secondMax);

    }
}
