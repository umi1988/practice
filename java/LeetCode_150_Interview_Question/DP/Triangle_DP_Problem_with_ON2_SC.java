package LeetCode_150_Interview_Question.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are
 * on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 * Example 1:-
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 * Example 2:-
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 *
 *
 */

public class Triangle_DP_Problem_with_ON2_SC
{
    public int minimumTotal(List<List<Integer>> triangle) {
        //calculate the height of triangle
        int height = triangle.size();

        //create a dp 2d array to store the result in bottom up approach
        int[][] dp = new int[height+1][height+1];

        // Now start the for loop from the bottom of the triangle
        for(int level = height-1; level>=0; level--){
            for(int i=0;i<=level;i++){
                // Add the minimum amongst 2 adjacent elements from bottom level
                dp[level][i] = triangle.get(level).get(i)
                        + Math.min(dp[level+1][i], dp[level+1][i+1]);

            }
        }
        return dp[0][0];//  top dp array value will be the answer
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        Triangle_DP_Problem_with_ON2_SC solver = new Triangle_DP_Problem_with_ON2_SC();
        System.out.println("Minimum Path Sum: " + solver.minimumTotal(triangle));
    }
}
