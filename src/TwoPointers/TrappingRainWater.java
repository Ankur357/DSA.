package TwoPointers;

import java.util.Arrays;

public class TrappingRainWater {

    // Method to calculate trapped rain water
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left]; // add water if any
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right]; // add water if any
                right--;
            }
        }
        return total;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};
        int[] height3 = {1,2,3,4};
        int[] height4 = {4,3,2,1};

        System.out.println("Input: " + Arrays.toString(height1));
        System.out.println("Trapped Water: " + trap(height1)); // 6

        System.out.println("Input: " + Arrays.toString(height2));
        System.out.println("Trapped Water: " + trap(height2)); // 9

        System.out.println("Input: " + Arrays.toString(height3));
        System.out.println("Trapped Water: " + trap(height3)); // 0

        System.out.println("Input: " + Arrays.toString(height4));
        System.out.println("Trapped Water: " + trap(height4)); // 0
    }
}
