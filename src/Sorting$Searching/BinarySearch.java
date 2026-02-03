package Sorting$Searching;

import java.util.Arrays;

public class BinarySearch {

    // Method to perform binary search
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1; // exclude mid
            } else {
                left = mid + 1;  // exclude mid
            }
        }
        return -1;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;

        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;

        int[] nums3 = {1};
        int target3 = 1;

        int[] nums4 = {};
        int target4 = 5;

        System.out.println("Input: " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output index: " + search(nums1, target1)); // 4

        System.out.println("Input: " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output index: " + search(nums2, target2)); // -1

        System.out.println("Input: " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output index: " + search(nums3, target3)); // 0

        System.out.println("Input: " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output index: " + search(nums4, target4)); // -1
    }
}

