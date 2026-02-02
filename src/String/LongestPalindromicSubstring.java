package String;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    // Method to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int len1 = findPalindrome(s, i, i);
            // Even-length palindrome
            int len2 = findPalindrome(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update answer if longer palindrome found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // Helper method to expand around center
    private static int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "ac";
        String s5 = "forgeeksskeegfor";

        System.out.println("Input: \"" + s1 + "\" -> " + longestPalindrome(s1));
        System.out.println("Input: \"" + s2 + "\" -> " + longestPalindrome(s2));
        System.out.println("Input: \"" + s3 + "\" -> " + longestPalindrome(s3));
        System.out.println("Input: \"" + s4 + "\" -> " + longestPalindrome(s4));
        System.out.println("Input: \"" + s5 + "\" -> " + longestPalindrome(s5));
    }
}

