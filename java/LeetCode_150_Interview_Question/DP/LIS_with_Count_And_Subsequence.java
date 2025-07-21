package LeetCode_150_Interview_Question.DP;

import java.util.*;

/**
 *Concept:-
 * We simulate a variation of "patience sorting" using an auxiliary list lisTracker that keeps track of the
 * smallest tail elements of increasing subsequences of different lengths.
 *
 * Additionally, we track indices and predecessors to reconstruct the full LIS.
 *
 * Algorithm Steps
 * 1> Initialize tracking structures:
 *      lisTracker: a list of increasing values — used for binary search.
 *      lisIndex[i]: stores the index of the original array element that ends the LIS of length i+1.
 *      prevIndex[i]: tracks the predecessor index of nums[i] in the LIS chain (for reconstruction).
 *      Fill prevIndex with -1.
 *
 * 2> Iterate over input array:
 * For each nums[i], use Collections.binarySearch(lisTracker, nums[i]) to find the position idx.
 *       If idx < 0, convert to insertion point via -(idx + 1).
 * Update lisTracker:
 *       If idx is equal to size, append nums[i] (extends LIS).
 *      Else, replace lisTracker[idx] with nums[i] (smaller tail).
 * Update lisIndex[idx] = i.
 *      If idx > 0, update prevIndex[i] = lisIndex[idx - 1].
 *
 *3> Reconstruct LIS subsequence:
 * Start at lastIndex = lisIndex[length - 1].
 * Backtrack using prevIndex until -1.
 * Collect the elements in reverse order using a LinkedList.
 *
 *4> Return the LIS and its length.
 *
 *Time and Space Complexity:-
 * Time	- O(n log n)
 * Space -	O(n)
 * Binary Search - 	O(log n) per element
 * Reconstruction -	O(n)
 *
 */
public class LIS_with_Count_And_Subsequence
{
    public static Pair<List<Integer>, Integer> findLIS(int[] nums) {
        int n = nums.length;

        // Stores the actual numbers forming LIS (for binarySearch)
        List<Integer> lisTracker = new ArrayList<>();

        // Stores indices where each number sits in LIS
        int[] lisIndex = new int[n];
        // Stores predecessor indices to reconstruct path
        int[] prevIndex = new int[n];
        Arrays.fill(prevIndex, -1);

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            int idx = Collections.binarySearch(lisTracker, num);
            if (idx < 0) idx = -(idx + 1);

            if (idx == lisTracker.size()) {
                lisTracker.add(num);
            } else {
                lisTracker.set(idx, num);
            }

            lisIndex[idx] = i;
            if (idx > 0) prevIndex[i] = lisIndex[idx - 1];
        }

        // Reconstruct LIS
        LinkedList<Integer> lis = new LinkedList<>();
        int lastIndex = lisIndex[lisTracker.size() - 1];
        while (lastIndex >= 0) {
            lis.addFirst(nums[lastIndex]);
            lastIndex = prevIndex[lastIndex];
        }

        return new Pair<>(lis, lis.size());
    }

    // Helper class to return LIS and its count together
    static class Pair<U, V> {
        public final U lis;
        public final V count;

        public Pair(U lis, V count) {
            this.lis = lis;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        Pair<List<Integer>, Integer> result = findLIS(arr);

        System.out.println("🟢 LIS Sequence: " + result.lis);
        System.out.println("📏 LIS Length: " + result.count);
    }
}

