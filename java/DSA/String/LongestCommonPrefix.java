package DSA.String;

import java.util.Arrays;


/**
 * Find the longest common prefix string among an array of strings.
 *
 *
 O(n·log n)
 */
public class LongestCommonPrefix
{
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        Arrays.sort(strs);// this will sort the strings
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) ==last.charAt(i))
        {
                i++;
        }
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(input);
        System.out.println(result);
    }
}
