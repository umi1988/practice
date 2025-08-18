package DSA.String;

/**
 *
 * A palindrome mirrors around its center. So for each character (and between characters),
 * expand outward to find the longest palindrome.
 *
 * 🪜 Steps
 * 1> Iterate through each character in the string.
 * 2> For each index i, expand around two centers:
        One for odd-length palindrome (i)
        One for even-length palindrome (i and i+1)
 * 3> Track the maximum length and start index of the longest palindrome found.
 * 4> Return the substring from start to start + maxLen.
 *
 *
 Time Complexity	O(n²)
 Space Complexity	O(1)
 *
 */
public class LongestPalindromicSubstring_Optimised_Solution
{
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // Odd length
            int len2 = expandFromCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end   = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring_Optimised_Solution finder = new LongestPalindromicSubstring_Optimised_Solution();
        String input = "babad";
        System.out.println("Longest Palindromic Substring: " + finder.longestPalindrome(input)); // "bab" or "aba"
    }
}
