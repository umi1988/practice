package LeetCode_150_Interview_Question.Array_String;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:-
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:-
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Steps:-
 *
 * 1> Initialize Two Pointers:
    left = 0, right = n - 1
    leftMax = 0, rightMax = 0
    water = 0

 * 2> Process from both ends inward:
    While left < right:
        If height[left] < height[right]:
             If height[left] >= leftMax: update leftMax
             Else: water += leftMax - height[left]
            Move left++
        Else:
            If height[right] >= rightMax: update rightMax
            Else: water += rightMax - height[right]
            Move right--

 * 3> Return water
 */
public class TrappingRainWater_Leetcode {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] elevation = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped rain water: " + trap(elevation));
    }
}
