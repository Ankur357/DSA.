package DynamicProgramming;

public class HouseRobberII {

    static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];

            // Case 1: Rob houses from 0 to n-2
            int max1 = robHelper(nums, 0, n - 1);

            // Case 2: Rob houses from 1 to n-1
            int max2 = robHelper(nums, 1, n);

            return Math.max(max1, max2);
        }

        // Linear House Robber DP helper
        private int robHelper(int[] nums, int start, int end) {
            int rob1 = 0;  // Max money until two houses ago
            int rob2 = 0;  // Max money until previous house
            int max = 0;   // Current max

            for (int i = start; i < end; i++) {
                max = Math.max(nums[i] + rob1, rob2);  // Rob current or skip
                rob1 = rob2;  // Shift previous values
                rob2 = max;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Robbing houses in a circle
        int[] nums1 = {2, 3, 2};
        System.out.println("Max money robbed (Example 1): " + sol.rob(nums1)); // Output: 3

        // Test case 2: Robbing houses in a circle
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Max money robbed (Example 2): " + sol.rob(nums2)); // Output: 4

        // Test case 3: Robbing houses in a circle
        int[] nums3 = {2, 7, 9, 3, 1};
        System.out.println("Max money robbed (Example 3): " + sol.rob(nums3)); // Output: 11
    }
}