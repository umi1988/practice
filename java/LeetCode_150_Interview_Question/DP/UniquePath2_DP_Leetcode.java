package LeetCode_150_Interview_Question.DP;


/**
 *Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 *
 * Unique Paths II — In-Place DP Algorithm Steps
  1>Check Starting Point
        If obstacleGrid[0][0] == 1, return 0 👉 The robot can't start if there's an obstacle on the first cell.
 2> Initialize Start Cell
         Set obstacleGrid[0][0] = 1 👉 This represents one way to start — we treat it like a DP cell now.
 3> Initialize First Column For each row i from 1 to m-1:
         If current cell obstacleGrid[i][0] == 0 and the cell above has a path (obstacleGrid[i-1][0] == 1), set obstacleGrid[i][0] = 1
        Else, set obstacleGrid[i][0] = 0 👉 A single column gets blocked if any obstacle shows up.
 4> Initialize First Row For each column j from 1 to n-1:
         Same logic as above: check if cell to the left is reachable, and no obstacle at current cell.
5>  Fill DP Grid For all cells (i, j) from 1 onward:
        If obstacleGrid[i][j] == 0:
            Update obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1] 👉 Sum the ways to reach from top and left
        Else:
             Set obstacleGrid[i][j] = 0 (blocked)
 6> Return Final Answer
        Return obstacleGrid[m-1][n-1] 👉 This cell now holds the number of valid unique paths.
 *
 *
 *
 Time	O(m × n)	Each cell is updated once
 Space	O(1) extra	Uses input grid for DP, no extra storage
 *
 */
public class UniquePath2_DP_Leetcode
{
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if(grid[0][0] == 1)
            return 0;
        grid[0][0] = 1;
        // Initialize first column
        for(int i=1;i<m;i++){
            grid[i][0] = (grid[i][0]==0 && grid[i-1][0]==1) ? 1:0;
        }

        // Initialize first row
        for (int j = 1; j < n; j++) {
            grid[0][j] = (grid[0][j] == 0 && grid[0][j - 1] == 1) ? 1 : 0;
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println("Total no of way for Unique Path Sum (Optimized): " + uniquePathsWithObstacles(grid));
    }
}
