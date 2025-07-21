package LeetCode_150_Interview_Question.DP;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Time complexity:
 * O(m*n) where m is the total no of different coins and n is the total amount we have to make.
 *
 * Space complexity:
 * O(n) because n space we need to memoize.
 *
 */
public class CoinChange_DP_Problem
{
    public static int coinChange(int[] coins, int amount) {
        //check the edge case
        if(amount<1)
            return 0;

        //create a DP array
        int[] minCoinsDP = new int[amount +1];

        for(int i =1; i<= amount;i++){
            minCoinsDP[i] = Integer.MAX_VALUE;
            // try each coin
            for(int coin : coins){
                if(coin <= i && minCoinsDP[i-coin] != Integer.MAX_VALUE)
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1+minCoinsDP[i-coin]);
            }
        }
        if (minCoinsDP[amount] == Integer.MAX_VALUE)
            return -1;
        return minCoinsDP[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int []{1,2,5,9};
        int amt = 11;

        int i = coinChange(coins, amt);
        System.out.println(i);
    }
}
