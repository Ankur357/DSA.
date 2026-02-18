package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Stack<Integer> st = new Stack<>();
            int n = heights.length;

            // Traverse through all bars, with an extra iteration at the end (i == n)
            for (int i = 0; i <= n; i++) {
                // When i == n, set the current height to 0 to process remaining elements in the stack
                int currentHeight = (i == n) ? 0 : heights[i];

                // While stack is not empty and the current height is less than the bar at stack's top
                while (!st.isEmpty() && currentHeight < heights[st.peek()]) {
                    // Pop the top of the stack to calculate the area for the rectangle
                    int height = heights[st.pop()];
                    // The width of the rectangle is determined by the difference in indices
                    int width = st.isEmpty() ? i : i - st.peek() - 1;
                    // Update maxArea with the maximum found so far
                    maxArea = Math.max(maxArea, height * width);
                }
                // Push the current index to the stack
                st.push(i);
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        // Create an instance of Solution
        Solution sol = new Solution();

        // Test case 1: heights = [2, 1, 5, 6, 2, 3]
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle area (heights1): " + sol.largestRectangleArea(heights1));  // Output: 10

        // Test case 2: heights = [2, 4]
        int[] heights2 = {2, 4};
        System.out.println("Largest rectangle area (heights2): " + sol.largestRectangleArea(heights2));  // Output: 4

        // Test case 3: heights = [1, 2, 3, 4, 5]
        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println("Largest rectangle area (heights3): " + sol.largestRectangleArea(heights3));  // Output: 9

        // Test case 4: heights = [5, 4, 1, 2]
        int[] heights4 = {5, 4, 1, 2};
        System.out.println("Largest rectangle area (heights4): " + sol.largestRectangleArea(heights4));  // Output: 8
    }
}
