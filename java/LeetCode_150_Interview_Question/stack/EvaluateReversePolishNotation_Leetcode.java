package LeetCode_150_Interview_Question.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a R
 * everse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:-
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:-
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:-
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:-
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Key Idea:
 * In RPN, operands come before operators.
 *
 * Use a stack to store operands.
 *
 * When you encounter an operator, pop the top two operands, apply the operation, and push the result back.
 *
 * 🪜 Steps/ ALGO:-
 *
 * 1> Initialize an empty stack.
 * 2> Iterate through each token:
           If it's a number → push to stack.
           If it's an operator (+, -, *, /):
                Pop two operands: b = stack.pop(), a = stack.pop()
                Compute a op b and push the result.
 * 3> After processing all tokens, the stack will contain one value → return it.
 *
 * Complexity Analysis
 * Metric	Value	Notes
 * Time	O(n)	Each token is processed once
 * Space	O(n)	Stack stores up to n/2 operands
 *
 */
public class EvaluateReversePolishNotation_Leetcode
{
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int subtrahend = stack.pop();
                    int minuend = stack.pop();
                    stack.push(minuend - subtrahend);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_Leetcode sol = new EvaluateReversePolishNotation_Leetcode();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + sol.evalRPN(tokens)); // Output: 9
    }
}
