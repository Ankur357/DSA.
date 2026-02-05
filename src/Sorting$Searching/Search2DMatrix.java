package Sorting$Searching;

import java.util.Arrays;

public class Search2DMatrix {

    // Method to search target in a 2D matrix using binary search
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // Main method to run and test the solution
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target1 = 3;
        int target2 = 13;

        System.out.println("Matrix:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nTarget = " + target1);
        System.out.println("Found? " + searchMatrix(matrix1, target1)); // true

        System.out.println("\nTarget = " + target2);
        System.out.println("Found? " + searchMatrix(matrix1, target2)); // false
    }
}

