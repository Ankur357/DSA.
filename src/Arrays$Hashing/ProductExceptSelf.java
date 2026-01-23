package Arrays$Hashing;

import java.util.Arrays;

public class ProductExceptSelf {

    // Method to compute product of array except self
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int pre = 1;
        int post = 1;

        // Prefix pass
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre *= nums[i];
        }

        // Suffix pass
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= post;
            post *= nums[i];
        }

        return result;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));
    }
}
