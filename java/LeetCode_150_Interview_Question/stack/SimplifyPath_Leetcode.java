package LeetCode_150_Interview_Question.stack;

import java.util.*;

/**
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
 *
 * The rules of a Unix-style file system are as follows:
 *
 * A single period '.' represents the current directory.
 * A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
 * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
 * The simplified canonical path should follow these rules:
 *
 * The path must start with a single slash '/'.
 * Directories within the path must be separated by exactly one slash '/'.
 * The path must not end with a slash '/', unless it is the root directory.
 * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:-
 * Input: path = "/home/"
 * Output: "/home"

 * Explanation:
 * The trailing slash should be removed.
 *
 * Example 2:
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 *
 * Explanation:
 * Multiple consecutive slashes are replaced by a single one.
 *
 * Example 3:
 * Input: path = "/home/user/Documents/../Pictures"
 * Output: "/home/user/Pictures"
 *
 * Explanation:
 * A double period ".." refers to the directory up a level (the parent directory).
 *
 * Example 4:
 * Input: path = "/../"
 * Output: "/"
 *
 * Explanation:
 * Going one level up from the root directory is not possible.
 *
 * Example 5:
 * Input: path = "/.../a/../b/c/../d/./"
 * Output: "/.../b/d"
 *
 * Explanation:
 * "..." is a valid name for a directory in this problem.
 *
 *
 * Problem Summary
 * Given an absolute path in a Unix-style file system, simplify it to its canonical form:
 * "." means current directory → ignore it
 * ".." means move up one directory → pop from stack
 * Multiple slashes (//) are treated as a single slash
 * The result must start with / and have no trailing slash
 *
 * ALGO:-
 *1> Split the path by / to get components.
 *2> Initialize a stack to track valid directory names.
 *3> Iterate through components:
 *       Skip empty strings and "."
 *      If ".." → pop from stack if not empty
 *      Else → push the directory name onto the stack
 *4> Reconstruct the path by joining stack elements with / and prefixing with /
 *
 *
 Time	O(n)	One pass through path components
 Space	O(n)	Stack stores directory names
 *
 *
 */
public class SimplifyPath_Leetcode
{
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }

        // Build the simplified path
        StringBuilder result = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            result.append("/").append(it.next());
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath_Leetcode sol = new SimplifyPath_Leetcode();
        String input = "/a//b////c/d//././/..";
        System.out.println("Simplified Path: " + sol.simplifyPath(input)); // Output: /a/b/c
    }
}
