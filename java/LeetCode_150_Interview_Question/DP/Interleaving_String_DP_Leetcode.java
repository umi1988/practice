package LeetCode_150_Interview_Question.DP;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings
 * respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Explanation: One way to obtain s3 is:
 * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
 * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
 * Since s3 can be obtained by interleaving s1 and s2, we return true.
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 * Example 3:
 *
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 *
 *
 * ALgo
 *
 * 🧠 Problem Summary
 * Given strings s1, s2, and s3, determine if s3 is formed by interleaving s1 and s2 such that:
 *
 * Characters from s1 and s2 appear in order.
 *
 * All characters from both strings are used.
 *
 * 🔧 Optimized Algorithm (1D DP)
 * 💡 Key Idea:
 * Use a 1D boolean array dp[] of size n + 1 (where n = s2.length()) to track whether s3[0..i+j] can be formed by interleaving s1[0..i] and s2[0..j].
 *
 * 🪜 Steps:
 * 1> Check Lengths: If s1.length() + s2.length() != s3.length(), return false.
 * 2> Initialize DP Array: dp[j] represents whether s3[0..i+j] can be formed.
 * 3> Iterate Over s1 and s2: For each i in s1 and j in s2:
         If i > 0, update dp[j] = dp[j] && s1[i-1] == s3[i+j-1]
         If j > 0, update dp[j] = dp[j] || (dp[j-1] && s2[j-1] == s3[i+j-1])
 * 4> Return dp[n]: Final result is stored in dp[s2.length()]
 *
 *
 * Complexity Analysis
 * Metric	Value	Notes
 * Time	O(m × n)	Nested loop over s1 and s2
 * Space	O(n)	Only one row of DP used
 */
public class Interleaving_String_DP_Leetcode
{
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j - 1;
                if (i > 0)
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(k);
                if (j > 0)
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Interleaving_String_DP_Leetcode solution = new Interleaving_String_DP_Leetcode();

        // 🔍 Test Case 1
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println("Is Interleave (Test Case 1): " + solution.isInterleave(s1, s2, s3)); // true

        // 🔍 Test Case 2
        String s4 = "aabcc";
        String s5 = "dbbca";
        String s6 = "aadbbbaccc";

        System.out.println("Is Interleave (Test Case 2): " + solution.isInterleave(s4, s5, s6)); // false
    }

}
