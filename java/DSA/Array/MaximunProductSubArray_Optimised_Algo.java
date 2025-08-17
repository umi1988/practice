package DSA.Array;

public class MaximunProductSubArray_Optimised_Algo
{
    public static int maxProductSubArray(int[] nums){
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for(int i=0;i<n;i++){
            // if any of leftProduct or rightProduct become 0 then update it to 1
            leftProduct = leftProduct==0?1:leftProduct;
            rightProduct = rightProduct==0?1:rightProduct;
            // prefix product
            leftProduct *=nums[i];// product from starting point i
            // suffix product
            rightProduct *=nums[n-1-i]; // product from last point n-1-i
            ans = Math.max(ans,Math.max(leftProduct,rightProduct));// check the max with leftProduct or rightProduct or ans
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 3, -2, -5, 6, -1, 4};
        int max = maxProductSubArray(nums);
        System.out.println(max);
    }
}
