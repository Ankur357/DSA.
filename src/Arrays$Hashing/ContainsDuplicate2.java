package Arrays$Hashing;

import java.util.HashMap;

public class ContainsDuplicate2 {

    // Method to check for nearby duplicates within distance k
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true; // Nearby duplicate found
                }
            }
            map.put(nums[i], i);
        }
        return false; // No nearby duplicates
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;

        System.out.println("Test Case 1: " + containsNearbyDuplicate(nums1, k1)); // true
        System.out.println("Test Case 2: " + containsNearbyDuplicate(nums2, k2)); // true
        System.out.println("Test Case 3: " + containsNearbyDuplicate(nums3, k3)); // false
    }
}

