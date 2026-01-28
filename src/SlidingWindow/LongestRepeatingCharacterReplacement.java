package SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    // Method to find the longest repeating character replacement
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        int maxOccurrence = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxOccurrence = Math.max(maxOccurrence, map.get(ch));

            // Shrink window if replacements needed > k
            if (right - left + 1 - maxOccurrence > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;

        String s2 = "AABABBA";
        int k2 = 1;

        System.out.println("Test Case 1: " + characterReplacement(s1, k1)); // 4
        System.out.println("Test Case 2: " + characterReplacement(s2, k2)); // 4
    }
}

