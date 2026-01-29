package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class SlidingWindowMaximum {

    // Method to find maximum in each sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>(); // stores values (monotonic decreasing)

        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            // Remove smaller elements from the back
            while (!queue.isEmpty() && queue.getLast() < nums[j]) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);

            // When window size reaches k
            if (j - i + 1 == k) {
                result[i] = queue.getFirst();

                // Remove outgoing element
                if (queue.getFirst() == nums[i]) {
                    queue.removeFirst();
                }
                i++;
            }
        }
        return result;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;

        int[] nums2 = {9, 11};
        int k2 = 2;

        int[] nums3 = {4, -2};
        int k3 = 1;

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(nums1, k1)));
        // Expected: [3, 3, 5, 5, 6, 7]

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(nums2, k2)));
        // Expected: [11]

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(nums3, k3)));
        // Expected: [4, -2]
    }
}
