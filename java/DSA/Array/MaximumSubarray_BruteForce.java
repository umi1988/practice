package DSA.Array;

/**
 * Find the contiguous subarray with the largest sum.
 *
 * This method involves iterating through all possible contiguous subarrays, calculating their sums,
 * and keeping track of the maximum sum found. This approach has a time complexity of O(N^2),
 * where N is the number of elements in the array.
 *
 *
 *Brute Force – O(n²)
 *
 * For the array [-2, 1, -3, 4, -1, 2, 1, -5, 4], the contiguous subarray with the
 * largest sum is [4, -1, 2, 1], which has a sum of 6.
 */
public class MaximumSubarray_BruteForce
{
    public static int maxSubArrayBrute(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j=i;j<nums.length;j++){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArrayBrute(nums);
        System.out.println(max);
    }
}
