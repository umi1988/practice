package LeetCode_150_Interview_Question.Digit_Manipulation;

public class MaximumSwap_LeetCode {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10]; // stores last index of each digit

        // Populate last occurrence of each digit
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        // Traverse digits from left to right
        for (int i = 0; i < digits.length; i++) {
            int current = digits[i] - '0';
            // Check for any larger digit (9 down to current + 1)
            for (int d = 9; d > current; d--) {
                if (last[d] > i) {
                    // Swap and return result
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num; // Return original number if no swap makes it larger
    }

    public static void main(String[] args) {
        MaximumSwap_LeetCode sol = new MaximumSwap_LeetCode();

        // 🔍 Sample test cases
        int num1 = 2736;
        //int num2 = 9973;
        //int num3 = 98368;

        System.out.println("Max swap of " + num1 + " => " + sol.maximumSwap(num1)); // Output: 7236
       // System.out.println("Max swap of " + num2 + " => " + sol.maximumSwap(num2)); // Output: 9973
       // System.out.println("Max swap of " + num3 + " => " + sol.maximumSwap(num3)); // Output: 98863
    }
}
