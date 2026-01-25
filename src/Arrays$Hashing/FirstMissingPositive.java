package Arrays$Hashing;

import java.util.Arrays;

public class FirstMissingPositive {

    // Method to find the first missing positive integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean isOneExist = false;

        // Step 1: Normalize the array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) isOneExist = true;
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }

        if (!isOneExist) return 1;

        // Step 2: Mark presence using index hashing
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[value] = -Math.abs(nums[value]);
            }
        }

        // Step 3: Find first missing positive
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }

        // Step 4: Check for n
        if (nums[0] > 0) return n;

        return n + 1;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[][] testCases = {
                {3, 4, -1, 1},
                {1, 2, 0},
                {7, 8, 9, 11, 12},
                {1, 2, 3},
                {2}
        };

        for (int[] test : testCases) {
            int result = firstMissingPositive(test.clone());
            System.out.println(Arrays.toString(test) + " -> " + result);
        }
    }
}

