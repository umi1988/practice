package LeetCode_150_Interview_Question.Array_String;

/**
 *
 * Benefits:-
 * No Stack → reduced space usage
 *
 * Fewer operations → split once, append in reverse
 *
 * Handles extra spaces with trim() and split("\\s+")
 *
 * ✅ Time Complexity: O(n) ✅ Space Complexity : O(n) But less internal overhead — only String[] and StringBuilder.
 *
 */

public class ReverseAWord_Without_Stack
{
    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = reverseWords("the sky is blue");
        System.out.println(s);
    }
}
