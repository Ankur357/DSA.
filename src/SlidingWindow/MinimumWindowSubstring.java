package SlidingWindow;

import java.util.*;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] map = new int[128];

        // Build frequency map from t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;
        int counter = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (map[c] > 0) counter--;
            map[c]--;
            right++;

            // Shrink the window when it is valid
            while (counter == 0) {
                if (right - left < minWindow) {
                    minWindow = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) counter++;
                left++;
            }
        }

        return minWindow == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minWindow);
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";

        String s2 = "a";
        String t2 = "a";

        String s3 = "a";
        String t3 = "aa";

        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: " + minWindow(s1, t1)); // BANC

        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: " + minWindow(s2, t2)); // a

        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: " + minWindow(s3, t3)); // ""
    }
}
