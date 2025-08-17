package DSA.Array;

/**
 * Kadane's Algorithm:
 * This is a dynamic programming approach that provides an efficient solution with a time complexity of O(N).
 * It works by iterating through the array and maintaining two variables:
 *
 * current_max: The maximum sum of a subarray ending at the current position.
 * global_max: The overall maximum sum found so far across all subarrays.
 *
 * At each element, current_max is updated to be the maximum of the current element itself or the
 * current element added to the current_max from the previous step. global_max is then updated to be
 * the maximum of global_max and current_max.
 * V
 * ariations:
 * The core concept of contiguous subarrays extends to other problems, such as:
 *
 * Maximum Product Subarray: Finding the contiguous subarray with the largest product.
 * Smallest Sum Contiguous Subarray: Finding the contiguous subarray with the smallest sum.
 * Continuous Subarray Sum (Divisible by K): Determining if a contiguous subarray exists whose sum is a
 *          multiple of a given integer K.
 *
 *
 *   Optimized – O(n)/O(1)
 */

public class MaximumSubarray_Optimized_Kadane_Algo
{
    public static int maxSubArray1(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i =1;i<nums.length;i++){
            currSum = Math.max(nums[i], nums[i]+ currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray1(nums);
        System.out.println(max);
    }
}
