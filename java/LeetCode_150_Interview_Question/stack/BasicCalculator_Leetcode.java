package LeetCode_150_Interview_Question.stack;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * Key Idea:
 * Use a stack to track the current sign context and accumulate the result as you parse the expression.
 *
 * 🪜 Step-by-Step Logic/ ALGO:
 * 1> Initialize:
 *      sum = 0 → running total
 *      sign = 1 → current sign (+1 or -1)
 *      stack → stores previous sum and sign when entering parentheses
 *
 * 2> Iterate through each character in the string:
 *      If digit → build the full number and add sign × number to sum
 *      If '+' → set sign = +1
 *      If '-' → set sign = -1
 *      If '(' → push current sum and sign to stack, reset sum = 0, sign = 1
 *      If ')' → pop sign and previous sum, combine with current sum
 *
 * 3> Return final sum
 *
 * Complexity Analysis
 * Metric	Value	Notes
 * Time	O(n)	Each character is processed once
 * Space	O(n)	Stack stores signs and sums for nested expressions
 *
 */
public class BasicCalculator_Leetcode
{
        public int calculate(String s) {
            int sum = 0, sign = 1;
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0;

            while (i < s.length()) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    sum += sign * num;
                    continue; // already advanced i
                } else if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                } else if (c == '(') {
                    stack.push(sum);
                    stack.push(sign);
                    sum = 0;
                    sign = 1;
                } else if (c == ')') {
                    int prevSign = stack.pop();
                    int prevSum = stack.pop();
                    sum = prevSum + prevSign * sum;
                }
                i++;
            }

            return sum;
        }

        public static void main(String[] args) {
            BasicCalculator_Leetcode calc = new BasicCalculator_Leetcode();
            String expr = "(1+(4+5+2)-3)+(6+8)";
            System.out.println("Result: " + calc.calculate(expr)); // Output: 23
        }
}
