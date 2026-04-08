package DynamicProgramming;

public class MaximumProductSubarray {

    static class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;

            int max = nums[0];
            int min = nums[0];
            int result = max;

            for (int i = 1; i < nums.length; i++) {
                int curr = nums[i];

                int temp = Math.max(curr, Math.max(curr * min, curr * max));
                min = Math.min(curr, Math.min(curr * min, curr * max));
                max = temp;
                result = Math.max(result, max);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Max Product of nums1: " + sol.maxProduct(nums1)); // Output: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println("Max Product of nums2: " + sol.maxProduct(nums2)); // Output: 0

        int[] nums3 = {-2, 3, -4};
        System.out.println("Max Product of nums3: " + sol.maxProduct(nums3)); // Output: 24
    }
}
