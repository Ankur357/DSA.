package SlidingWindow;

import java.util.Arrays;

public class PermutationInString {

    // Method to check if s2 contains a permutation of s1
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        // Initialize frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        // Sliding window comparison
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(arr1, arr2)) return true;

            // Add next character to the window
            arr2[s2.charAt(i + s1.length()) - 'a']++;
            // Remove character going out of the window
            arr2[s2.charAt(i) - 'a']--;
        }

        // Check the last window
        return Arrays.equals(arr1, arr2);
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        String s3 = "ab";
        String s4 = "eidboaoo";

        System.out.println("Test Case 1: " + checkInclusion(s1, s2)); // true
        System.out.println("Test Case 2: " + checkInclusion(s3, s4)); // false
    }
}
