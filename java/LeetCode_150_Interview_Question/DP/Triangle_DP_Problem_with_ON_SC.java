package LeetCode_150_Interview_Question.DP;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Optimized Java Solution for Triangle LeetCode Problem
 * Algorithm
 * Problem Understanding:-
 *
 * The Triangle problem involves finding the minimum path sum from top to bottom of a triangle.
 * Each step can move to adjacent numbers on the row below.
 *
 * Approach:-
 * Use dynamic programming to solve the problem efficiently.
 * Start from the bottom row and move upwards, updating the minimum path sum for each element.
 *
 * Steps:-
 *1> Initialize a DP array with the last row of the triangle.
 *2> Iterate from the second last row to the top row.
 *3> For each element, update the DP value as the sum of the current element and the minimum of the two
      adjacent elements in the row below.
 *4> The top element of the DP array will contain the minimum path sum.
 *
 *
 * Explanation
 * Time Complexity:-
 *
 * The algorithm iterates through all elements of the triangle once, resulting in O(n^2) complexity,
 * where n is the number of rows.
 *
 * Space Complexity:-
 * The space complexity is O(n) due to the DP array used for computation.
 *
 * This solution is efficient and avoids the overhead of recursion by using a
 * bottom-up dynamic programming approach.
 */
public class Triangle_DP_Problem_with_ON_SC
{
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize DP array with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterate from the second last row to the top row
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        Triangle_DP_Problem_with_ON_SC solver = new Triangle_DP_Problem_with_ON_SC();
        System.out.println("Minimum Path Sum: " + solver.minimumTotal1(triangle));
    }
}
