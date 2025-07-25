package LeetCode_150_Interview_Question.DP;

/**
 * Instead of maintaining an entire m x n dp[][] matrix, we can use a single array dp[] of size n
 * to store and update the minimum path sums row by row.
 *
 * moving only right or down, using O(n) space.
 *
 *
 * Step-by-Step Approach:
 *
 *1> Initialize a 1D array dp[] of size n to store the minimum path sums for the current row.
 *2> Set dp[0] = grid[0][0] — the starting cell.
 *3> Fill the first row by accumulating values:
        dp[j] = dp[j - 1] + grid[0][j]
 *4> For each subsequent row i:
       Update the first column:
            dp[0] += grid[i][0]
       For each cell grid[i][j] where j > 0:
            dp[j] = min(dp[j], dp[j - 1]) + grid[i][j]
            dp[j] now holds the minimum path sum to reach grid[i][j]
 *5> After the last row is processed, dp[n - 1] contains the final answer.
 *
 *
 *
 Time	O(m × n)
 Space	O(n)
 This version uses only linear space, making it ideal for large grids with limited memory.
 */
public class MinimumPathSum_LeetCode_Memoization
{
    public static int minPathSumMemoized(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0];

        // initialize first row
        for (int j=1;j<n;j++){
            dp[j]=dp[j-1]+grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];  // update first column
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Minimum Path Sum (Optimized): " + minPathSumMemoized(grid));
    }
}
