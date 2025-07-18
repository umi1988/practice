package LeetCode_150_Interview_Question.DP;
/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Example 1:-
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:-
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:-
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */

public class LongestIncreasingSubsequenceLeetCode
{
    public int lengthOfLIS(int[] nums) {
        int[] memoizationArray = new int[nums.length];// creating a memoizationArray   to store the subsequence

        for(int i=1;i< nums.length;i++){// starting main pointer i with 1
            for(int j=0;j<i;j++){ // starting second pointer j with 0
                if(nums[i]> nums[j]){
                    if(memoizationArray[j]+1 > memoizationArray[i]){// here we are checking the value at index j in memoizationArray(default will be zero) and then incrementing if the above condition meet.
                        memoizationArray[i] = memoizationArray[j]+1;// // here we are updating the value at index i in memoizationArray(default will be zero) by index j value with 1.
                    }
                }
            }
        }
        int maxIndex = 0;
        for(int i=0;i<memoizationArray.length;i++){
            if(memoizationArray[i]> memoizationArray[maxIndex]){
                maxIndex = i;
            }
        }
        return memoizationArray[maxIndex]+1;
    }
}
