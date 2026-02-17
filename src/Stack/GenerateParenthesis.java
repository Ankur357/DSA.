package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            backtrack(list, new StringBuilder(), 0, 0, n);
            return list;
        }

        public void backtrack(List<String> list, StringBuilder sb, int open, int close, int max) {
            if (sb.length() == 2 * max) {
                list.add(sb.toString());
                return;
            }

            if (open < max) {
                sb.append("(");
                backtrack(list, sb, open + 1, close, max);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (close < open) {
                sb.append(")");
                backtrack(list, sb, open, close + 1, max);
                sb.deleteCharAt(sb.length() - 1);
            }
         }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3;
        int n2 = 1;

        System.out.println("Parentheses (n=3): " + sol.generateParenthesis(n1));
        System.out.println("Parentheses (n=1): " + sol.generateParenthesis(n2));
    }
}