package DynamicProgramming;

public class HouseRobber {

    static class Solution {
        public int rob(int[] nums) {
            int rob1 = 0;  // Maximum money robbed until the previous house
            int rob2 = 0;  // Maximum money robbed until the current house
            int max = 0;   // Variable to keep track of the max money robbed

            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i] + rob1, rob2);  // Either rob current house or skip it
                rob1 = rob2;  // Move rob2 to rob1 for the next iteration
                rob2 = max;   // Update rob2 to the current max
            }

            return max;  // Return the maximum amount of money robbed
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Robbing houses with values [1, 2, 3, 1]
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Max money robbed (Example 1): " + sol.rob(nums1)); // Output: 4 (Rob 1st and 3rd house)

        // Test case 2: Robbing houses with values [2, 7, 9, 3, 1]
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Max money robbed (Example 2): " + sol.rob(nums2)); // Output: 12 (Rob 1st, 3rd, and 5th house)
    }
}