/*
Create a function permute() with parameters as input string and starting index of the string
Call this function with values input string and starting index, idx as 0
    In this function, if idx becomes size of the string then print the same string
        Else run a for loop from idx to size – 1 and swap the current element in the for loop with the s[idx]
        Then again call this same function by increasing the value of idx by 1
        After that again swap the previously swapped values to initiate backtracking
 */

public class PermutationOfString {
    // Function to print permutations of the string
    // This function takes two parameters:
    // 1. String
    // 2. Starting index of the string.
    static void permuteRec(StringBuilder s, int idx) {
        // Base case
        if (idx == s.length() - 1) {
            System.out.println(s);
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            // Swapping
            swap(s, idx, i);
            // First idx+1 characters fixed
            permuteRec(s,idx + 1);
            // Backtrack
            swap(s, idx, i);
        }
    }
    // Helper function to swap characters in the StringBuilder
    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
    // Wrapper function
    static void permute(String s) {
        permuteRec(new StringBuilder(s), 0);
    }
    public static void main(String[] args) {
        String s = "ABC";
        permute(s);
    }
}
