package Graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    static class Solution {

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();
            if (heights == null || heights.length == 0 || heights[0].length == 0)
                return result;

            int row = heights.length;
            int col = heights[0].length;

            boolean[][] pacific = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                dfs(i, 0, pacific, heights);  // Pacific edge
                dfs(i, col - 1, atlantic, heights);  // Atlantic edge
            }

            for (int i = 0; i < col; i++) {
                dfs(0, i, pacific, heights);  // Pacific edge
                dfs(row - 1, i, atlantic, heights);  // Atlantic edge
            }

            // Collect the coordinates where both oceans are reachable
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        result.add(List.of(i, j));
                    }
                }
            }
            return result;
        }

        private void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
            int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            ocean[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= heights.length || newCol < 0 ||
                        newCol >= heights[0].length || ocean[newRow][newCol] ||
                        heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }

                dfs(newRow, newCol, ocean, heights);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Test case for Pacific and Atlantic water flow
        int[][] heights = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        System.out.println("Cells that can flow to both the Pacific and Atlantic: ");
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }

        // Example 2: Another test case (you can add more test cases as needed)
        int[][] heights2 = {
                {5, 1, 0, 3},
                {1, 4, 2, 2},
                {1, 3, 1, 1}
        };

        System.out.println("\nCells that can flow to both the Pacific and Atlantic (Second Test Case): ");
        result = solution.pacificAtlantic(heights2);
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}