package Stack;

import java.util.Stack;

public class ValidParentheses {

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(' || ch == '{' || ch == '[') {
                    st.push(ch);
                } else {
                    if (st.isEmpty()) return false;

                    if (st.peek() == '(' && ch == ')') st.pop();
                    else if (st.peek() == '{' && ch == '}') st.pop();
                    else if (st.peek() == '[' && ch == ']') st.pop();
                    else return false;
                }
            }

            return st.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println(s1 + " -> " + sol.isValid(s1));
        System.out.println(s2 + " -> " + sol.isValid(s2));
        System.out.println(s3 + " -> " + sol.isValid(s3));
        System.out.println(s4 + " -> " + sol.isValid(s4));
        System.out.println(s5 + " -> " + sol.isValid(s5));
    }
}
