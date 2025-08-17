package DSA.Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumWithOptimizedApproach
{
    public static int[] twoSumWithOptimizedApproach (int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();// create a map
        for (int i=0 ;i<nums.length;i++){// first loop from i=0
            int complement = target-nums[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement),i}; // this will return when we will get the two sum
            else
                map.put(nums[i],i);
        }
        return new int[]{-1,-1};//if map don't have combination then return this.
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,1,6,19,44};
        int target = 50;
        int[] finalArry = twoSumWithOptimizedApproach(nums, target);
        System.out.println(finalArry[0] + " , " + finalArry[1]);

    }
}
