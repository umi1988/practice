package LeetCode_150_Interview_Question.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This is the Longest Increasing Subsequence problem solution in O(nlog n) Time Complexity and O(n) Space Complexity
 *NOTE -: Binary Search will have O(log n)
 * Algo :-
 *
 * 1> we have the Arrays with integer values in it as a input to the function.
 * 2>We build a temporary array list where:
   2.1> list[i] holds the smallest possible positions of an increasing subsequence of length i+1
 * 2.2> We perform binary search to place each number correctly in this array
 * 2.3> Length of list will give LIS length
 *
 */

public class LongestIncresingSubsequenceLeetCode_with_NLOGN
{
    public static int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            int index = Collections.binarySearch(list,num);
            System.out.println("Index :- " + index);

            if(index < 0) //element not found
                index = -(index+1); //insertion position

            if(index==list.size())
                list.add(num);//insert at end -- extends longest subsequence
            else
                list.set(index,num);//replace -- update existing positions
        }
        return list.size();
    }


    public static void main(String[] args) {
            int[] input = new int[]{10,9,2,5,3,7,101,18};
            int i = lengthOfLIS(input);
        System.out.println(i);
    }
}
