package DynamicProgramming;

import java.util.Arrays;

public class UniquePathsDP {

    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            // Fill first row and first column with 1
            for (int[] row : dp) {
                Arrays.fill(row, 1);
            }

            // Fill the DP table
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int m1 = 3, n1 = 7;
        System.out.println("Unique paths (3x7 grid): " + sol.uniquePaths(m1, n1)); // Output: 28

        // Test case 2
        int m2 = 3, n2 = 2;
        System.out.println("Unique paths (3x2 grid): " + sol.uniquePaths(m2, n2)); // Output: 3

        // Test case 3
        int m3 = 7, n3 = 3;
        System.out.println("Unique paths (7x3 grid): " + sol.uniquePaths(m3, n3)); // Output: 28
    }
}