import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        

        // this comparator is doing the sorting based on the second digit in the nums array
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer i, Integer j){
                if(i%10> j%10)
                    return 1;
                else
                    return -1;
            }
        };

        List<Integer> nums = new ArrayList<>();
        nums.add(89);
        nums.add(61);
        nums.add(75);
        nums.add(53);
        nums.add(42);
        nums.add(30);

        Collections.sort(nums,comp);

        System.out.println(nums);

    }
}
