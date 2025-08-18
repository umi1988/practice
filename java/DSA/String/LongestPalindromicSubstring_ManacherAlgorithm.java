package DSA.String;

/**
 * Manacher’s Algorithm is a brilliant linear-time solution for finding the Longest Palindromic Substring.
 * It’s more complex than center expansion, but incredibly efficient—especially for large strings.
 *
 * Manacher’s Algorithm transforms the string to handle even and odd-length palindromes uniformly
 * by inserting a special character (like #) between every character and at the ends.
 *
 * Example: Original: "abba" Transformed: ^#a#b#b#a#$ (^ and $ are sentinels to avoid bounds checking)
 *
 * Steps of the Algorithm:-
 * 1>Preprocess the string by inserting # between characters and adding sentinels ^ and $.
 * 2> Create an array P[] where P[i] stores the radius of the palindrome centered at i.
 * 3> Maintain two variables:
        C: center of the current rightmost palindrome
        R: right boundary of that palindrome
 * 4> For each position i:
        Mirror position: mirror = 2*C - i
        If i < R, set P[i] = min(R - i, P[mirror])
        Try to expand the palindrome centered at i
        If expansion goes beyond R, update C and R
 * 5> Find the maximum value in P[] and its center to extract the longest palindrome.
 *
 *
 Time Complexity	O(n)
 Space Complexity	O(n)

 */
public class LongestPalindromicSubstring_ManacherAlgorithm
{
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform the string
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");
        String T = sb.toString();

        int[] P = new int[T.length()];
        int center = 0, right = 0;

        // Step 2: Populate P[]
        for (int i = 1; i < T.length() - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }

            // Expand around center i
            while (T.charAt(i + (1 + P[i])) == T.charAt(i - (1 + P[i]))) {
                P[i]++;
            }

            // Update center and right boundary
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        // Step 3: Find the longest palindrome
        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < P.length - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String input = "abacdfgdcaba";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
    }
}
