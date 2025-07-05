public class Container_With_Most_Water_LeetCode
{
    public static int maxArea(int[] height) {
        int left_ptr = 0;
        int right_ptr = height.length-1;
        int maxArea = 0;

        while(left_ptr < right_ptr){
            int presentArea = Math.min(height[left_ptr], height[right_ptr])*(right_ptr - left_ptr);// Area = length * breadth
            maxArea = Math.max(maxArea, presentArea);

            if(height[left_ptr] < height[right_ptr]){
                left_ptr++;
            }else{
                right_ptr--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
       int [] height = new int[]{1,8,6,2,5,4,8,3,7};
       int maxArea = maxArea(height);
        System.out.println(maxArea);
    }
}

