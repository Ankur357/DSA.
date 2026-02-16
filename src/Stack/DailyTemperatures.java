package Stack;

import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> st = new Stack<>();
            int[] ans = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    int index = st.pop();
                    ans[index] = i - index;
                }
                st.push(i);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temps2 = {30, 40, 50, 60};
        int[] temps3 = {30, 60, 90};

        System.out.println("Input: " + Arrays.toString(temps1));
        System.out.println("Output: " + Arrays.toString(sol.dailyTemperatures(temps1)));

        System.out.println("\nInput: " + Arrays.toString(temps2));
        System.out.println("Output: " + Arrays.toString(sol.dailyTemperatures(temps2)));

        System.out.println("\nInput: " + Arrays.toString(temps3));
        System.out.println("Output: " + Arrays.toString(sol.dailyTemperatures(temps3)));
    }
}
