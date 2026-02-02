package String;

import java.util.Arrays;

public class LongestCommonPrefix {

    // Method to find the longest common prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"interspecies", "interstellar", "interstate"};
        String[] strs4 = {"a"};
        String[] strs5 = {};

        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs1)); // "fl"

        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs2)); // ""

        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs3)); // "inters"

        System.out.println("Input: " + Arrays.toString(strs4));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs4)); // "a"

        System.out.println("Input: " + Arrays.toString(strs5));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs5)); // ""
    }
}

