package Stack;

import java.util.Stack;

public class LongestValidParentheses {

    static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> st = new Stack<>();
            int maxLength = 0;
            st.push(-1);  // Base index for the first valid parentheses

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push(i);  // Push index of '(' onto the stack
                } else {
                    st.pop();  // Pop the last element when encountering ')'
                    if (st.isEmpty()) {
                        st.push(i);  // If stack is empty, push the current index as the base for the next valid parentheses
                    } else {
                        maxLength = Math.max(maxLength, i - st.peek());  // Calculate the max length of valid parentheses
                    }
                }
            }

            return maxLength;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "(()())";
        String s2 = ")()())";
        String s3 = "";

        System.out.println("Longest valid parentheses (s1): " + sol.longestValidParentheses(s1));  // Output: 6
        System.out.println("Longest valid parentheses (s2): " + sol.longestValidParentheses(s2));  // Output: 4
        System.out.println("Longest valid parentheses (s3): " + sol.longestValidParentheses(s3));  // Output: 0
    }
}
