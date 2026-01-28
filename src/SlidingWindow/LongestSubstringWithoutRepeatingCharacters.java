package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    // Method to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int longestSubstring = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                longestSubstring = Math.max(longestSubstring, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return longestSubstring;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";

        System.out.println("Test Case 1: " + lengthOfLongestSubstring(s1)); // 3
        System.out.println("Test Case 2: " + lengthOfLongestSubstring(s2)); // 1
        System.out.println("Test Case 3: " + lengthOfLongestSubstring(s3)); // 3
        System.out.println("Test Case 4: " + lengthOfLongestSubstring(s4)); // 0
    }
}

