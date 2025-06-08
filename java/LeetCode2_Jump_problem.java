public class LeetCode2_Jump_problem
{
    public static boolean canJump(int[] nums) {
        int targetNumIndex = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(targetNumIndex<=i+nums[i]){
                targetNumIndex=i;
            }
        }
        return targetNumIndex == 0;
    }

    public static void main(String[] args) {
        int num[] = new int[]{2,3,1,1,4};
        int num2[] = new int[]{3,2,1,0,4};
        boolean b = canJump(num);
        boolean b2 = canJump(num2);
        System.out.println(b);
        System.out.println(b2);
    }
}
