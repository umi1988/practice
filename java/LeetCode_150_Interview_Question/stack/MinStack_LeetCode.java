package LeetCode_150_Interview_Question.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:-
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Key Idea:-
 * Use two stacks:
 * mainStack → stores all values
 * minStack → stores the minimum value at each level
 *
 * This way, minStack.peek() always gives the current minimum.
 *
 * ALGO-:
 * push(val):
 *      Push val to mainStack
 *      Push min(val, minStack.peek()) to minStack
 *
 * pop():
 *      Pop from both mainStack and minStack
 *
 * top():
 *      Return mainStack.peek()
 *
 * getMin():
 *      Return minStack.peek()
 *

 Operation	Time	Space
 push	O(1)	O(1)
 pop	O(1)	O(1)
 top	O(1)	O(1)
 getMin	O(1)	O(1)
 *
 */
public class MinStack_LeetCode
{
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack_LeetCode() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack_LeetCode stack = new MinStack_LeetCode();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println("Min: " + stack.getMin()); // -3
        stack.pop();
        System.out.println("Top: " + stack.top());    // 0
        System.out.println("Min: " + stack.getMin()); // -2
    }
}
