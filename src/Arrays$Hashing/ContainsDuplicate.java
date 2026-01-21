package Arrays$Hashing;

import java.util.HashMap;

public class ContainsDuplicate {

    // Method to check if array contains duplicates
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true; // Duplicate found
            }
            map.put(nums[i], i);
        }

        return false; // No duplicates
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println("Test Case 1: " + containsDuplicate(nums1)); // false
        System.out.println("Test Case 2: " + containsDuplicate(nums2)); // true
    }
}
