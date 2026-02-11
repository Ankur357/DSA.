package LinkedList;

import java.util.Arrays;

public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Phase 1: Detect cycle
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Phase 2: Find entrance to cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};
        int[] nums3 = {1, 1};

        System.out.println(Arrays.toString(nums1) + " -> " + findDuplicate(nums1)); // 2
        System.out.println(Arrays.toString(nums2) + " -> " + findDuplicate(nums2)); // 3
        System.out.println(Arrays.toString(nums3) + " -> " + findDuplicate(nums3)); // 1
    }
}

