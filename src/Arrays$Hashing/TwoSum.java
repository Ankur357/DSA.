package Arrays$Hashing;

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    // Method to find indices of two numbers that add up to target
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{}; // no solution found
    }

    // Main method to execute and test the solution
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result.length > 0) {
            System.out.println("Indices: " + Arrays.toString(result));
        } else {
            System.out.println("No solution found.");
        }
    }
}

