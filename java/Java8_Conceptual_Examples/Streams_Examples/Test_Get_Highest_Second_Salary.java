package Java8_Conceptual_Examples.Streams_Examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test_Get_Highest_Second_Salary
{
    public static void main(String[] args) {
        List<Integer> lst  = new ArrayList<>();
        lst.add(9000);
        lst.add(3000);
        lst.add(5000);
        lst.add(1000);

        Optional<Integer> secondHighest  = lst.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighest);


    }
}
