package LeetCode_150_Interview_Question.DP;

/**
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:-
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:-
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 */

/**
 *
 * in-place dynamic programming solution for the Minimum Path Sum problem
 *
 *Time Complexity: O(m × n)
 * You’re traversing the entire grid, which has m rows and n columns.
 * Every cell is visited exactly once.
 * All operations inside the loops run in constant time.
 * ✅ So the time complexity is O(m × n).
 *
 * Space Complexity: O(1) (Extra space)
 * You’ve cleverly updated the grid in place, which means no additional storage is used for the DP table.
 * Memory usage is constant beyond the input.
 *
 * 🧠 Note: If we do not count the input grid itself (which is usually the case in space complexity analysis),
 * then your solution uses constant extra space.
 */
public class MinimumPathSum_LeetCode
{
    public static int minPathSum(int[][] grid){
        if(grid == null || grid.length==0) return 0;
        for (int i =0; i<grid.length;i++){
            for (int j=0; j<grid[0].length;j++){
                if(i==0 && j==0) continue;
                if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                }else if( j==0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    int minPath = Math.min(grid[i][j-1], grid[i-1][j]);
                    grid[i][j] += minPath;
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int minPathSumValue = minPathSum(grid);
        System.out.println("MIN PATH SUM:- " + minPathSumValue);
    }
}
