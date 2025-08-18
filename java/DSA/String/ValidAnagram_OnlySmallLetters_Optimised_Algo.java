package DSA.String;
/**
 * Given two strings s1 and s2, return true if s2 is an anagram of s1.
 *
 *  String s1 = "listen";
 *  String s2 = "silent";
 *
 *  ALGO-
 *
 1> Count character frequencies using an array.
 2> Increment for s, decrement for t.
 3> If all counts are zero, they’re anagrams.
 *
 * Optimized – Count Characters – O(n)
 */
public class ValidAnagram_OnlySmallLetters_Optimised_Algo {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26]; // assuming lowercase a-z
        for (int i=0;i<s.length();i++){
            //System.out.print("  AAA " + (s.charAt(i) - 'a'));
            count[s.charAt(i) - 'a']++;
           // System.out.print("  BBB " + (t.charAt(i) - 'a'));
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count){
            if(c!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram_OnlySmallLetters_Optimised_Algo validator = new ValidAnagram_OnlySmallLetters_Optimised_Algo();
        String s1 = "listen";
        String s2 = "silent";
        System.out.println("Are they anagrams? " + validator.isAnagram(s1, s2)); // true
    }


}
