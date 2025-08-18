package DSA.Array;

/**
 * Move all 0's to the end while maintaining the relative order of non-zero elements.
 *
 * Optimized – O(n), in-place
 */
public class MoveZeroes_OptimizedAlgo
{
    public static void moveZeroesOptimized(int[] nums) {
        int insertPos = 0;
        // here we are checking num not equal to zeros then we are updating the same array with num
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        // this below condition is to update the zeros in the same array based on insertPos number
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (!(i == nums.length - 1))
                System.out.print(",");
        }

    }

    public static void main(String[] args) {
        int nums[] = new int[]{-2, 0, -3, 0, -1, 2, 1, 0, 4};
        moveZeroesOptimized(nums);
    }
}
