package Sorting$Searching;

import java.util.Arrays;

public class MajorityElement {

    // Method to find the majority element using Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {1};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Majority Element: " + majorityElement(nums1)); // 3

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Majority Element: " + majorityElement(nums2)); // 2

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Majority Element: " + majorityElement(nums3)); // 1
    }
}

