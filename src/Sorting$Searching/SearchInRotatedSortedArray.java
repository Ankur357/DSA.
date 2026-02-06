package Sorting$Searching;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    // Method to search target in rotated sorted array
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;

        int[] nums3 = {1};
        int target3 = 0;

        int[] nums4 = {1, 3};
        int target4 = 3;

        System.out.println("Input: " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output index: " + search(nums1, target1)); // 4

        System.out.println("\nInput: " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output index: " + search(nums2, target2)); // -1

        System.out.println("\nInput: " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output index: " + search(nums3, target3)); // -1

        System.out.println("\nInput: " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output index: " + search(nums4, target4)); // 1
    }
}

