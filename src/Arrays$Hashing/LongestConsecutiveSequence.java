package Arrays$Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Method to find the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestLength = 1;

        for (int s : set) {
            // Start counting only if s is the start of a sequence
            if (!set.contains(s - 1)) {
                int count = 1;
                int x = s;

                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }

                longestLength = Math.max(longestLength, count);
            }
        }

        return longestLength;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {};

        System.out.println("Test Case 1: " + longestConsecutive(nums1)); // 4
        System.out.println("Test Case 2: " + longestConsecutive(nums2)); // 9
        System.out.println("Test Case 3: " + longestConsecutive(nums3)); // 0
    }
}

