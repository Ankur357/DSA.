package DynamicProgramming;

public class ClimbingStairs {

    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;  // Base case: 1 way to reach the 0th step (do nothing)
            dp[1] = 1;  // Base case: 1 way to reach the 1st step (1 step)

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];  // Ways to reach the current step
            }
            return dp[n];  // Return the total ways to reach the nth step
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Climbing 3 stairs
        int n1 = 3;
        System.out.println("Ways to climb " + n1 + " stairs: " + sol.climbStairs(n1)); // Output: 3

        // Test case 2: Climbing 5 stairs
        int n2 = 5;
        System.out.println("Ways to climb " + n2 + " stairs: " + sol.climbStairs(n2)); // Output: 8
    }
}