package DSA.Array;

import java.io.FilterOutputStream;
import java.util.Spliterator;

/**
 * Find indices of the two numbers in an array that add up to a target.
 *
 *  TIME COMPLEXITY - O(n2)
 */
public class TwoSumWithBruteForceApproach
{
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i=0 ;i<nums.length;i++){// first loop from i=0
            for (int j=i+1;j<nums.length;j++){// second loop from j=i+1
                if(nums[i] + nums[j] == target){// if target match with i and j combination then return i , j
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};//if target doesn't match with i and j combination then return this.
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,1,6,19,44};
        int target = 51;
        int[] finalArry = twoSumBrute(nums, target);
        System.out.println(finalArry[0] + " , " + finalArry[1]);

    }
}
