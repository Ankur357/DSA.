package TwoPointers;

import java.util.Arrays;

public class NextPermutation {

    // Method to rearrange numbers into the next lexicographically greater permutation
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Find element just larger than nums[i] and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 1, 5};
        int[] nums4 = {1, 3, 2};

        nextPermutation(nums1);
        nextPermutation(nums2);
        nextPermutation(nums3);
        nextPermutation(nums4);

        System.out.println("Next permutation of [1, 2, 3]: " + Arrays.toString(nums1)); // [1, 3, 2]
        System.out.println("Next permutation of [3, 2, 1]: " + Arrays.toString(nums2)); // [1, 2, 3]
        System.out.println("Next permutation of [1, 1, 5]: " + Arrays.toString(nums3)); // [1, 5, 1]
        System.out.println("Next permutation of [1, 3, 2]: " + Arrays.toString(nums4)); // [2, 1, 3]
    }
}

