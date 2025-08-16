package LeetCode_150_Interview_Question.DP;

/**
 * ALGO
 * 1> if only 1 element just return it
 * 2> create a array to store the maximum loot at each index
 * 3> memoize maximum loots at first 2 indexes
 *   dp[0]=nums[0];
 *    dp[1]=Math.max(nums[0], nums[1]);
 * 4> use this core logic to fill the complete db array
 *       dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
 * 5> return the last element from the memoize array
 *
 * * Type	Complexity
 *  * Time	- > O(n) - because we are iteration through the array only once
 *  * Space ->	O(n) - as we used memoized array to store memoized result.
 */
public class HouseRobber_DP_Problem_1
{
    public static int rob1(int[] nums) {

        //if only 1 element just return it
        if(nums.length<2)
            return nums[0];

        //create a array to store the maximum loot at each index
        int dp[] = new int[nums.length];

        //memoize maximum loots at first 2 indexes
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);

        // use this core logic to fill the complete db array
        for (int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        // int[] arr = new int []{2,7,9,3,1};
        int[] arr = new int []{6,9,6};
        System.out.println("Max amount profit for house robbed:-" + + rob1(arr));

    }
}
