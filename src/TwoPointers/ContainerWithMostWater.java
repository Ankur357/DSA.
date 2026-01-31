package TwoPointers;

import java.util.Arrays;

public class ContainerWithMostWater {

    // Method to calculate the maximum area
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 1};
        int[] height3 = {4, 3, 2, 1, 4};
        int[] height4 = {1, 2, 1};

        System.out.println("Input: " + Arrays.toString(height1));
        System.out.println("Max Area: " + maxArea(height1)); // 49

        System.out.println("Input: " + Arrays.toString(height2));
        System.out.println("Max Area: " + maxArea(height2)); // 1

        System.out.println("Input: " + Arrays.toString(height3));
        System.out.println("Max Area: " + maxArea(height3)); // 16

        System.out.println("Input: " + Arrays.toString(height4));
        System.out.println("Max Area: " + maxArea(height4)); // 2
    }
}
