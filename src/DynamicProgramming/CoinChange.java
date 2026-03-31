package DynamicProgramming;

import java.util.*;

public class CoinChange {

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1); // initialize "infinity"
            dp[0] = 0; // 0 coins to make amount 0

            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Fewest coins (Example 1): " + sol.coinChange(coins1, amount1)); // Output: 3

        // Test case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Fewest coins (Example 2): " + sol.coinChange(coins2, amount2)); // Output: -1

        // Test case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Fewest coins (Example 3): " + sol.coinChange(coins3, amount3)); // Output: 0

        // Test case 4
        int[] coins4 = {186, 419, 83, 408};
        int amount4 = 6249;
        System.out.println("Fewest coins (Example 4): " + sol.coinChange(coins4, amount4)); // Large test case
    }
}