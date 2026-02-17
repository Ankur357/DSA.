package Stack;

import java.util.HashSet;
import java.util.Stack;

public class MinRemoveToMakeValid {

    static class Solution {
        public String minRemoveToMakeValid(String s) {
            Stack<Integer> st = new Stack<>();
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    st.push(i);
                } else if (ch == ')') {
                    if (!st.isEmpty()) st.pop();
                    else set.add(i);
                }
            }

            while (!st.isEmpty()) {
                set.add(st.pop());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "a)b(c)d";
        String s2 = "))((";
        String s3 = "(a(b(c)d)";

        System.out.println("Result: " + sol.minRemoveToMakeValid(s1)); // ab(c)d
        System.out.println("Result: " + sol.minRemoveToMakeValid(s2)); // ""
        System.out.println("Result: " + sol.minRemoveToMakeValid(s3)); // a(b(c)d)
    }
}