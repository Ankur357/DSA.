package DynamicProgramming;

import java.util.*;

public class DecodeWays {

    static class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

            int prev1 = 1; // dp[i-1]
            int prev2 = 1; // dp[i-2]

            for (int i = 1; i < s.length(); i++) {
                int current = 0;

                // Single digit decoding
                if (s.charAt(i) != '0') {
                    current += prev1;
                }

                // Two digits decoding
                int val = Integer.parseInt(s.substring(i - 1, i + 1));
                if (val >= 10 && val <= 26) {
                    current += prev2;
                }

                // Move the window forward
                prev2 = prev1;
                prev1 = current;
            }

            return prev1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        String s1 = "11106";
        System.out.println("Number of ways to decode '" + s1 + "': " + sol.numDecodings(s1)); // Output: 2

        // Test case 2
        String s2 = "226";
        System.out.println("Number of ways to decode '" + s2 + "': " + sol.numDecodings(s2)); // Output: 3

        // Test case 3
        String s3 = "0";
        System.out.println("Number of ways to decode '" + s3 + "': " + sol.numDecodings(s3)); // Output: 0

        // Test case 4
        String s4 = "10";
        System.out.println("Number of ways to decode '" + s4 + "': " + sol.numDecodings(s4)); // Output: 1

        // Test case 5
        String s5 = "27";
        System.out.println("Number of ways to decode '" + s5 + "': " + sol.numDecodings(s5)); // Output: 1
    }
}