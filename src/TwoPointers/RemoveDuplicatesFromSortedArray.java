package TwoPointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    // Method to remove duplicates from a sorted array
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {1};

        int k1 = removeDuplicates(nums1);
        int k2 = removeDuplicates(nums2);
        int k3 = removeDuplicates(nums3);

        System.out.println("Result length: " + k1);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums1, k1)));

        System.out.println("Result length: " + k2);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums2, k2)));

        System.out.println("Result length: " + k3);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums3, k3)));
    }
}

