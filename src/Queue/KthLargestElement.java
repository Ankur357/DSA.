package Queue;


import java.util.PriorityQueue;
import java.util.Arrays;

public class KthLargestElement {

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int num : nums) {
                minHeap.add(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            return minHeap.poll();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;

        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + sol.findKthLargest(nums1, k1));

        System.out.println("\nInput: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + sol.findKthLargest(nums2, k2));
    }
}

