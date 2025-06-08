
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(9,5,12,55,3,4,8,7,2);

        System.out.println("Streams way of doing thing");
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n->n%2==0);
        Stream<Integer> s3 = s2.map(n->n*2);
        int result = s3.reduce(0,(a,b)-> a+b);
        
        System.out.println(result);

       // s2.forEach(n->System.out.println(n));
       //s2.forEach(n->System.out.println(n)); // we can't use stream again once used

       System.out.println("more simplified  way");
      int res =  nums.stream()
                .filter(n->n%2==0)
                .map(n->n*2)
                .reduce(0,(a,b)-> a+b);
    System.out.println(res);


        System.out.println("old way of doing things");
        int sum = 0;
        for(Integer i : nums){
            if(i%2==0){
                i = i*2;
                sum = sum+i;
            }
        }
        System.out.println(sum);
        
    }
}
