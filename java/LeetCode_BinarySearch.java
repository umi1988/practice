public class LeetCode_BinarySearch {
    public static int search(int[] nums, int target){
        int low = 0, high = nums.length - 1;


        if (nums.length == 1 ) {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }

        if (nums.length == 2 ) {
            if(nums[0] == target)
                return 0;
            else if(nums[1] == target)
                return 1;
            else return -1;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1;
    }

    public static void main(String[] args) {
       // int arr[] = { 2, 3, 4, 10, 40 };
        //int arr[] = { 2, 5};
       // int arr[] = { 2,5};
        int arr[] = {-1,0,5};
        int n = arr.length;
        int x = 5;

        int search = search(arr, x);
        System.out.println(search);
    }

}
