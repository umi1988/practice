package LeetCode_150_Interview_Question.DP;

/**
 * You're climbing a staircase with n steps. You can take either 1 or 2 steps at a time.
 * How many distinct ways can you climb to the top?
 *
 * This is equivalent to computing the nth number in the Fibonacci sequence, because:
 * 1> To get to step n, you could’ve come from step n-1 (via 1 step), or from step n-2 (via 2 steps).
 * 2> So: ways(n) = ways(n-1) + ways(n-2)
 *
 * Algo -
 * 1> If n is 0 or 1, return 1 (base cases)
 * 2> Set:
 *   a = 1 → ways to reach step 0
 *   b = 1 → ways to reach step 1
 * 3> Loop from 2 to n:
 *  Calculate temp = a + b
 *  Shift: a = b, b = temp
 * 4> Return b — number of ways to reach step n
 *
 * Time & Space Complexity
 * ⏱️ Time	- O(n)
 * 📦 Space	- O(1)
 */
public class Climbing_Staircase_Problem
{
    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        int a = 1; // ways to step 0
        int b = 1; // ways to step 1
        for (int i=2;i<=n;i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    public static void main(String[] args) {
        int steps = 5;
        System.out.println("Ways to climb " + steps + " stairs: " + climbStairs(steps));
    }
}
