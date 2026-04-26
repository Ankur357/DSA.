package DynamicProgramming;

import java.util.*;

public class WordBreak {

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);

            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            int maxWordLen = 0;
            for (String word : wordDict) {
                maxWordLen = Math.max(maxWordLen, word.length());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = Math.max(0, i - maxWordLen); j < i; j++) {
                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Word Break (Example 1): " + sol.wordBreak(s1, dict1)); // true

        // Test case 2
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Word Break (Example 2): " + sol.wordBreak(s2, dict2)); // true

        // Test case 3
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Word Break (Example 3): " + sol.wordBreak(s3, dict3)); // false

        // Test case 4
        String s4 = "pineapplepenapple";
        List<String> dict4 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println("Word Break (Example 4): " + sol.wordBreak(s4, dict4)); // true
    }
}