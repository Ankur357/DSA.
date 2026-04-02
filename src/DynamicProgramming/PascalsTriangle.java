package DynamicProgramming;

import java.util.*;

public class PascalsTriangle {

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();
            if (numRows <= 0) return triangle;

            triangle.add(new ArrayList<>(Arrays.asList(1)));

            for (int i = 1; i < numRows; i++) {
                List<Integer> prevRow = triangle.get(i - 1);
                List<Integer> currRow = new ArrayList<>();
                currRow.add(1); // first element

                for (int j = 1; j < i; j++) {
                    currRow.add(prevRow.get(j - 1) + prevRow.get(j)); // sum of two above
                }

                currRow.add(1); // last element
                triangle.add(currRow);
            }

            return triangle;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int numRows1 = 5;
        System.out.println("Pascal's Triangle (" + numRows1 + " rows): " + sol.generate(numRows1));

        // Test case 2
        int numRows2 = 1;
        System.out.println("Pascal's Triangle (" + numRows2 + " row): " + sol.generate(numRows2));

        // Test case 3
        int numRows3 = 0;
        System.out.println("Pascal's Triangle (" + numRows3 + " rows): " + sol.generate(numRows3));
    }
}