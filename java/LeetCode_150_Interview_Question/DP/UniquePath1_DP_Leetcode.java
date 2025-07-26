package LeetCode_150_Interview_Question.DP;

/**
 * Algo :-
 *
 * 1> create a dp array to perform memoization with m*n
 * 2> Iterate it rows and columns wise
 * 3> if we are at the first row or first column there is only one way to reach that cell i.e. 1 ways.
 * 4> otherwise we have to follow this formula:- grid[i][j] = grid[i][j-1] + grid[i-1][j];
 * 5> return last values exist in m*n matrix by this grid[m-1][n-1]
 *
 * TC:- O(m*n)  because we need to iterate to every cell in the given matrix we have
 * SC:- O(m*n) because we need to memoize it in dp array.
 */
public class UniquePath1_DP_Leetcode
{
   public static int uniquePaths(int m, int n){
        // create a dp array to perform memoization
        int[][] grid = new int[m][n];

        // iterate over a grid
        for(int i=0; i<m;i++){
            for (int j=0; j<n;j++){
                //if we are at the first row or first column
                //there is only one way to reach that cell
                if(i==0 || j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println("Total no of Unique Path :- " + uniquePaths(3, 7));
    }
}
