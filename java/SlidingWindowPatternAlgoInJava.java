import java.util.ArrayList;

import static java.lang.Math.min;

/**
 * https://www.youtube.com/watch?v=lni2JkC9_1Y
 *
 */
public class SlidingWindowPatternAlgoInJava {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        //static int subarraySum(int[] arr, int target) {
        int total=0,sum=0,start=0,end=0,n=arr.length;

        ArrayList<Integer> res = new ArrayList<>();
        for( end = 0; end < n; end++){
            sum += arr[end];// add number to the sum
            while(sum>target && start<=end){ // window length ko decrease kar sakta hu
               // total = min(total, end-start+1);
                sum -=arr[start];
                start++;
            }

         //  end++;
            if(sum == target){
                res.add(start+1);
                res.add(end+1);
                // return res;
            }
        }
        //int i = total;
        //return total;
        res.add(-1);
        return res;

    }

    public static void main(String[] args) {
       int[] arr = new int[]{1,2,3,7,5};
       int target = 12;
        ArrayList<Integer> integers = subarraySum(arr, target);
       // int i = subarraySum(arr, target);
        System.out.println(integers);
       // int min = min(2, 6);
        //System.out.println(min);
    }
}
