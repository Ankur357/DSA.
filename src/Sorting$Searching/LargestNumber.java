package Sorting$Searching;

import java.util.Arrays;

public class LargestNumber {

    // Method to form the largest number
    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sort based on concatenation
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if largest is "0", result is "0"
        if (arr[0].equals("0")) return "0";

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {10, 2};
        int[] nums2 = {3, 30, 34, 5, 9};
        int[] nums3 = {0, 0};
        int[] nums4 = {1};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Largest Number: " + largestNumber(nums1)); // 210

        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Largest Number: " + largestNumber(nums2)); // 9534330

        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Largest Number: " + largestNumber(nums3)); // 0

        System.out.println("\nInput: " + Arrays.toString(nums4));
        System.out.println("Largest Number: " + largestNumber(nums4)); // 1
    }
}

