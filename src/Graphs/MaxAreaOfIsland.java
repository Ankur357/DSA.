package Graphs;

public class MaxAreaOfIsland {

    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int maxArea = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        int area = dfs(i, j, grid);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            return maxArea;
        }

        private int dfs(int row, int col, int[][] grid) {
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
                return 0;

            grid[row][col] = 0; // mark visited
            int area = 1;

            area += dfs(row + 1, col, grid);
            area += dfs(row - 1, col, grid);
            area += dfs(row, col + 1, grid);
            area += dfs(row, col - 1, grid);

            return area;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
                {0,0,1,0,0,0,1,1},
                {1,1,1,0,1,0,1,1},
                {0,1,0,0,1,0,0,0},
                {0,0,0,1,1,1,0,0}
        };

        int[][] grid2 = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        System.out.println("Max Area of Island (grid1): " + sol.maxAreaOfIsland(grid1));
        System.out.println("Max Area of Island (grid2): " + sol.maxAreaOfIsland(grid2));
    }
}