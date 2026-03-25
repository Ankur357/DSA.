package Graphs;

import java.util.*;

public class SwimInRisingWaterRunner {

    static class Solution {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            int left = grid[0][0];
            int right = n * n - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canSwim(grid, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canSwim(int[][] grid, int t) {
            int n = grid.length;
            boolean[][] visited = new boolean[n][n];
            return dfs(grid, visited, 0, 0, t);
        }

        private boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int t) {
            int n = grid.length;
            if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > t) {
                return false;
            }
            if (i == n - 1 && j == n - 1) return true;

            visited[i][j] = true;

            return dfs(grid, visited, i + 1, j, t) ||
                    dfs(grid, visited, i - 1, j, t) ||
                    dfs(grid, visited, i, j + 1, t) ||
                    dfs(grid, visited, i, j - 1, t);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
                {0, 2},
                {1, 3}
        };
        System.out.println("Minimum time to reach bottom-right (Test 1): " + sol.swimInWater(grid1));
        // Output: 3

        int[][] grid2 = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        System.out.println("Minimum time to reach bottom-right (Test 2): " + sol.swimInWater(grid2));
        // Output: 8
    }
}
