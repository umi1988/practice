
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachJava8Demo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,2,1,8,5,7,9);
        // first approach
        System.out.println("First Approach");
        for(Integer i : nums){
            System.out.println(i);
        }
        System.out.println();

        // second approach
        System.out.println("Second Approach");
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(i);
        }

         // third approach
        System.out.println("Third approach");
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
            
        };
        nums.forEach(con);


         // Fourth approach
         System.out.println("Fourth approach");
         Consumer<Integer> con_lambda = t -> System.out.println(t);
         nums.forEach(con_lambda);

         // Fifth approach
         System.out.println("Fifth approach");
        // Consumer<Integer> con_lambda_1= t -> System.out.println(t);
         nums.forEach(t -> System.out.println(t));

    }
    
}
