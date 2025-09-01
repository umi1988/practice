package Java8_Conceptual_Examples.Streams_Examples;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SecondHighestSalary_using_TreeSet
{
    public static void main(String[] args) {
        List<Integer> salaries = Arrays.asList(50000, 70000, 90000, 120000, 90000);

        // TreeSet automatically sorts and removes duplicates
        TreeSet<Integer> sortedSalaries = new TreeSet<Integer>(salaries);

        // Get second highest using lower()
        Integer highest = sortedSalaries.last();
        Integer secondHighest = sortedSalaries.lower(highest);
        System.out.println(secondHighest);
    }
}
