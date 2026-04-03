package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int maxLen = 1;
            Arrays.fill(dp, 1);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }

            return maxLen;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS Length (Example 1): " + sol.lengthOfLIS(nums1)); // Output: 4

        // Test case 2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("LIS Length (Example 2): " + sol.lengthOfLIS(nums2)); // Output: 4

        // Test case 3
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("LIS Length (Example 3): " + sol.lengthOfLIS(nums3)); // Output: 1
    }
}