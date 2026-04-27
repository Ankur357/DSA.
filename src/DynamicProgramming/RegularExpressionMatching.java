package DynamicProgramming;

import java.util.*;

public class RegularExpressionMatching {

    static class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            // Handle patterns like a*, a*b*, etc. for empty string
            for (int j = 2; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char sc = s.charAt(i - 1);
                    char pc = p.charAt(j - 1);

                    if (pc == sc || pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        dp[i][j] = dp[i][j - 2]; // zero occurrence
                        char prev = p.charAt(j - 2);
                        if (prev == sc || prev == '.') {
                            dp[i][j] |= dp[i - 1][j]; // one or more occurrences
                        }
                    }
                }
            }

            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        String s1 = "aa";
        String p1 = "a";
        System.out.println("Test case 1: " + sol.isMatch(s1, p1)); // false

        // Test case 2
        String s2 = "aa";
        String p2 = "a*";
        System.out.println("Test case 2: " + sol.isMatch(s2, p2)); // true

        // Test case 3
        String s3 = "ab";
        String p3 = ".*";
        System.out.println("Test case 3: " + sol.isMatch(s3, p3)); // true

        // Test case 4
        String s4 = "aab";
        String p4 = "c*a*b";
        System.out.println("Test case 4: " + sol.isMatch(s4, p4)); // true

        // Test case 5
        String s5 = "mississippi";
        String p5 = "mis*is*p*.";
        System.out.println("Test case 5: " + sol.isMatch(s5, p5)); // false
    }
}