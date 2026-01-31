package TwoPointers;

import java.util.Arrays;

public class TwoSumII {

    // Method to find two numbers such that they add up to target
    // Returns 1-based indices as per problem statement
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{}; // No solution found
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;

        int[] numbers3 = {-1, 0};
        int target3 = -1;

        System.out.println("Input: " + Arrays.toString(numbers1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(twoSum(numbers1, target1))); // [1, 2]

        System.out.println("Input: " + Arrays.toString(numbers2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(twoSum(numbers2, target2))); // [1, 3]

        System.out.println("Input: " + Arrays.toString(numbers3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(twoSum(numbers3, target3))); // [1, 2]
    }
}

