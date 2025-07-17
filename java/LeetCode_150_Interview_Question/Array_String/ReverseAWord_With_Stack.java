package LeetCode_150_Interview_Question.Array_String;

import java.util.Stack;

//Input: s = "the sky is blue"
//Output: "blue is sky the"

//Input: s = "  hello world  "
//Output: "world hello"

//Input: s = "a good   example"
//Output: "example good a"

/** Time Complexity:-
 * public static String reverseWords(String s)
 *
 * Breakdown:
 * 1> s.split(" ") → splits input into n words:
 * O(n) where n is the number of words.
 *
 * 2> Stack push loop:
 * Push each word → O(n)
 *
 * 3> Stack pop + StringBuilder append loop:
 * Pop each word and append → O(n)
 *
 * ✅ Total Time Complexity: O(n) (each word is visited 3 times: split, push, pop/append)
 *
 * Space Complexity:-
 * Breakdown:
 * 1> String[] str → stores n words → O(n)
 *
 * 2> Stack<String> → also holds n words → O(n)
 *
 * 3> StringBuilder sb → final reversed string → O(n)
 *
 * ✅ Total Space Complexity: O(n) Due to duplication in the array, stack, and result builder.
 *
 */

public class ReverseAWord_With_Stack {
    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int counter=0;
        String[] str = s.trim().split("\\s+");
        for(int i=0;i<str.length;i++){
            stack.push(str[i]);
            counter++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<counter;i++){
           String ss = stack.pop();
           sb.append(ss);
            if(!stack.empty())
                sb.append(" ");
        }
      return sb.toString();
    }
    public static void main(String[] args) {
        String s = reverseWords("the sky is blue");
        System.out.println(s);
    }
}
