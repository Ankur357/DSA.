package DynamicProgramming;

public class LongestCommonSubsequence {

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        String text1 = "abcde", text2 = "ace";
        System.out.println("LCS Length (Example 1): " + sol.longestCommonSubsequence(text1, text2)); // Output: 3

        // Test case 2
        String text3 = "abc", text4 = "abc";
        System.out.println("LCS Length (Example 2): " + sol.longestCommonSubsequence(text3, text4)); // Output: 3

        // Test case 3
        String text5 = "abc", text6 = "def";
        System.out.println("LCS Length (Example 3): " + sol.longestCommonSubsequence(text5, text6)); // Output: 0
    }
}