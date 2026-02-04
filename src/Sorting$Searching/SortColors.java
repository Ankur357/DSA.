package Sorting$Searching;

import java.util.Arrays;

public class SortColors {

    // Method to sort colors using Dutch National Flag algorithm
    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int curr = 0;

        while (curr <= high) {
            if (nums[curr] == 2) {
                swap(nums, curr, high);
                high--;
            } else if (nums[curr] == 0) {
                swap(nums, curr, low);
                low++;
                curr++;
            } else { // nums[curr] == 1
                curr++;
            }
        }
    }

    // Helper method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};
        int[] nums3 = {0};
        int[] nums4 = {1, 2, 0};

        System.out.println("Before: " + Arrays.toString(nums1));
        sortColors(nums1);
        System.out.println("After:  " + Arrays.toString(nums1));

        System.out.println("\nBefore: " + Arrays.toString(nums2));
        sortColors(nums2);
        System.out.println("After:  " + Arrays.toString(nums2));

        System.out.println("\nBefore: " + Arrays.toString(nums3));
        sortColors(nums3);
        System.out.println("After:  " + Arrays.toString(nums3));

        System.out.println("\nBefore: " + Arrays.toString(nums4));
        sortColors(nums4);
        System.out.println("After:  " + Arrays.toString(nums4));
    }
}

