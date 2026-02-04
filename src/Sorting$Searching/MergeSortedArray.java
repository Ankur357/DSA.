package Sorting$Searching;

import java.util.Arrays;

public class MergeSortedArray {

    // Method to merge nums2 into nums1 in-place
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // pointer for nums1
        int j = n - 1;        // pointer for nums2
        int k = m + n - 1;    // pointer for merged array

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Before merge:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));

        merge(nums1, m, nums2, n);

        System.out.println("\nAfter merge:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        // Expected: [1, 2, 2, 3, 5, 6]
    }
}

