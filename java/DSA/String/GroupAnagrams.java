package DSA.String;

import java.util.*;

/**
 * Grouping strings that are anagrams is a classic problem that’s both practical and elegant.
 * It’s widely used in search engines, dictionary tools, and data deduplication systems.
 *
 * Given an array of strings, group the strings that are anagrams of each other.
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
 *
 *
 * Algorithm: Hashing with Sorted Key
 *
 * Anagrams have the same characters in different order. So if you sort each string,
 * all anagrams will share the same sorted form.
 *
 * 🪜 Steps:-
 * 1> Create a Map<String, List<String>> to group anagrams.
 * 2> For each string:
        Sort the characters.
        Use the sorted string as a key.
        Add the original string to the corresponding list.
 * 3> Return the values of the map.
 *
 *
 Time Complexity	O(n * k log k) — n strings, each of length k
 Space Complexity	O(n * k) — storing grouped strings
 *
 */
public class GroupAnagrams
{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(input);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
