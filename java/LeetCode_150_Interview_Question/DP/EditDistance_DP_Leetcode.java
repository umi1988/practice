package LeetCode_150_Interview_Question.DP;


/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * Use a 1D array dp[] to store the minimum operations needed to convert prefixes of word1 to prefixes of word2.
 * We update the array row by row, reusing previous values.
 *
 * Steps:
 * 1> Let m = word1.length(), n = word2.length()
 * 2> Initialize a 1D array dp of size n + 1:
    dp[j] = operations to convert empty word1 to word2[0..j] → dp[j] = j
 * 3> Loop through each character i in word1:
 *      Track prev (value from previous row's diagonal)
 *      Set dp[0] = i (cost to delete i characters)
 *      Loop through each character j in word2:
 *          Save current dp[j] in temp
 *          If word1[i-1] == word2[j-1]: dp[j] = prev
 *          Else: dp[j] = 1 + min(prev, dp[j], dp[j-1])
 *          Update prev = temp
 *
 *
 *
 Time	O(m × n)	Each cell in the DP table is visited once
 Space	O(n)	Only one row of DP is stored
 */
public class EditDistance_DP_Leetcode
{
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }

                prev = temp;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        EditDistance_DP_Leetcode solver = new EditDistance_DP_Leetcode();

        String word1 = "horse";
        String word2 = "ros";

        int result = solver.minDistance(word1, word2);
        System.out.println("Edit Distance between \"" + word1 + "\" and \"" + word2 + "\": " + result);
    }
}
