package LeetCode_150_Interview_Question.DP;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:-
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".

 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.

 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 */

public class WordBreak_DP_Problem
{
    public static boolean wordBreak(String s, List<String> wordDict) {
        // convert the dictionary to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // find the maximum word length in the dictionary
        int maxLen = 0;
        for(String word : wordDict){
            maxLen = Math.max(maxLen,word.length());
        }

        int n = s.length();
        //dp[i] states if the substring s[0...i] can be segmented
        boolean[] dp = new boolean[n+1];

        //Base case: empty string is valid
        dp[0] = true;

        for(int i=1;i<=n;i++){
            // check prefixes of length up to maxLen
            for (int j=i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;//No need to check further prefixes
                }
            }
        }
    return dp[n];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean finalResult = wordBreak(s,wordDict);
        System.out.println(finalResult);

    }
}
