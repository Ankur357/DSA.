package Sorting$Searching;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    // Method to find first and last position of target
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findStart(nums, target), findLast(nums, target)};
    }

    // Find first occurrence (leftmost)
    private static int findStart(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; // move left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Find last occurrence (rightmost)
    private static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1; // move right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;

        int[] nums3 = {};
        int target3 = 0;

        System.out.println("Input: " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(searchRange(nums1, target1)));
        // Expected: [3, 4]

        System.out.println("Input: " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(searchRange(nums2, target2)));
        // Expected: [-1, -1]

        System.out.println("Input: " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(searchRange(nums3, target3)));
        // Expected: [-1, -1]
    }
}

