package LeetCode_150_Interview_Question.DP;



/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized
 * that all houses in this place form a binary tree. It will automatically contact the police if two
 * directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without
 * alerting the police.
 *
 *Example 1:
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * * Complexity
 *  *
 *  * TC - O(n)
 *  * SC - O(n)
 *
 *
 *
 *
 * # Approach
 * 1>  Base case. Just return {0,0} as you cannot rob anything
 * 2>  Apply recursion at left node
 * 3>  Apply recursion at right node
 * 4>  Create a arry with 2 index
 * 5>  store value if looted in [0]
 *
 *         options[0] = root.val + left_node_choices[1]+right_node_choices[1];
 *
 * 6>  store value if skipped in [0]
 *
 *         options[1] = Math.max(left_node_choices[0], left_node_choices[1]) +
 *                     Math.max(right_node_choices[0], right_node_choices[1]);
 *
 * 7> return
 *
 *     return options;
 *
 * 8> return max of option[0], option[1]
 */

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(int val) { this.val = val; }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class HouseRobber3_DP_Problems
{
    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }

    private int[] travel(TreeNode root){
        //Base case. Just return {0,0} as you cannot rob anything
        if(root==null)
            return new int[2];// return {0,0}

       int[] left_node_choices =  travel(root.left);
       int[] right_node_choices = travel(root.right);
       int[] options = new int[2];

       // store value if looted in [0]
       options[0] = root.val + left_node_choices[1]+right_node_choices[1];

        // store value if skipped in [0]
       options[1] = Math.max(left_node_choices[0], left_node_choices[1]) +
                    Math.max(right_node_choices[0], right_node_choices[1]);

       return options;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        HouseRobber3_DP_Problems solver = new HouseRobber3_DP_Problems();
        int maxRobbed = solver.rob(root);
        System.out.println("Maximum amount robbed: " + maxRobbed);
    }
}
