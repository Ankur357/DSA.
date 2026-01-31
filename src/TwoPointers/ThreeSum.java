package TwoPointers;

import java.util.*;

public class ThreeSum {

    // Method to find all unique triplets that sum to zero
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0, 0};
        int[] nums3 = {-2, 0, 1, 1, 2};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSum(nums1));
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2));
        // Expected: [[0, 0, 0]]

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + threeSum(nums3));
        // Expected: [[-2, 0, 2], [-2, 1, 1]]
    }
}
