package Sorting$Searching;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    // Method to find minimum element in rotated sorted array
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Left part is sorted
            if (nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            }
            // Right part is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }
        return ans;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {2, 1};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Minimum element: " + findMin(nums1)); // 1

        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Minimum element: " + findMin(nums2)); // 0

        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Minimum element: " + findMin(nums3)); // 11

        System.out.println("\nInput: " + Arrays.toString(nums4));
        System.out.println("Minimum element: " + findMin(nums4)); // 1
    }
}

