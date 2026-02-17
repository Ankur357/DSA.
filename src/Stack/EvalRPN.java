package Stack;

import java.util.Stack;
import java.util.Arrays;

public class EvalRPN {

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> st = new Stack<>();

            for (String token : tokens) {
                if (token.equals("/")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val2 / val1);
                }
                else if (token.equals("*")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val1 * val2);
                }
                else if (token.equals("-")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val2 - val1);
                }
                else if (token.equals("+")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val1 + val2);
                }
                else {
                    st.push(Integer.parseInt(token));
                }
            }

            return st.pop();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(Arrays.toString(tokens1) + " -> " + sol.evalRPN(tokens1));
        System.out.println(Arrays.toString(tokens2) + " -> " + sol.evalRPN(tokens2));
        System.out.println(Arrays.toString(tokens3) + " -> " + sol.evalRPN(tokens3));
    }
}
