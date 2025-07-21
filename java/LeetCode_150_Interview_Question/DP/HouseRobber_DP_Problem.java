package LeetCode_150_Interview_Question.DP;

/**
 * Test scenarios:-
 *
 * Example 1:-
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * 🧠 Logic Behind It
 * For each house, we decide:
 *      💰 To skip the current house and keep prevRob
 *      🏠 Or rob the current house and add its money to maxRob
 *
 * Each step:
 *       temp = maxRob, prevRob + curValue
 *       Then we slide the window forward:  prevRob = maxRob, maxRob = temp;
 *
 * Type	Complexity
 * Time	- > O(n)
 * Space ->	O(1)
 */
public class HouseRobber_DP_Problem
{
    public static int rob(int[] nums) {
        int prevRob = 0;
        int maxRob = 0;

        for (int curValue : nums) {
            int temp = Math.max(maxRob, prevRob + curValue);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }

    public static void main(String[] args) {
        int[] arr = new int []{2,7,9,3,1};
        System.out.println("Max amount profit for house robbed:-" + + rob(arr));

    }
}
