package LeetCode_150_Interview_Question.DP;


/**
 *Absolutely — Manacher's Algorithm is like a brainy shortcut for finding the longest palindromic
 * substring in linear time, something that brute-force and DP methods take quadratic time to do.
 * Let's unpack how it works in an intuitive way
 *
 * Manacher’s Strategy (Step-by-Step)
 *
 * 1. ✨ Preprocess the String
 * Insert a special character (like #) between every character, and sentinel characters at both ends:
 *
 * Original: abba
 *
 * Transformed: ^#a#b#b#a#$
 *
 * This helps treat even and odd-length palindromes uniformly.
 *
 * 2. 🧠 Use a Radius Array
 * Create p[], where p[i] stores the radius of the longest palindrome centered at position i.
 *
 * 3. 🪞 Mirror Optimization
 * Keep track of the current palindrome’s center (C) and right edge (R):
 *
 * For position i, compute its mirror index as 2*C - i
 *
 * If i < R, initialize p[i] = min(R - i, p[mirror])
 *
 * This uses known symmetry to reduce expansion
 *
 * 4. 🚀 Expand Where Needed
 * From position i, expand outward while characters match:
 *
 * text
 * processed[i + (1 + p[i])] == processed[i - (1 + p[i])]
 * Update p[i] and possibly update C and R if you pushed the boundary further.
 *
 * 5. 🎯 Extract Result
 * Scan p[] to find the maximum radius. That position corresponds to the center of the longest palindrome
 * — convert back to original string indices and return it.
 *
 *
 *
 Time	O(n)	Each position is expanded at most once
 Space	O(n)	For transformed string and radius array
 *
 */
public class Manacher {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Preprocess the string: insert '#' between characters and add sentinels
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");
        String processed = sb.toString();

        int n = processed.length();
        int[] p = new int[n]; // Array to store palindrome radius
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center i
            while (processed.charAt(i + (1 + p[i])) == processed.charAt(i - (1 + p[i]))) {
                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Find the longest palindrome
        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2; // Convert back to original string index
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Manacher m = new Manacher();
        String input = "abaxabaxabb";
        System.out.println("Longest Palindromic Substring: " + m.longestPalindrome(input));
    }
}
