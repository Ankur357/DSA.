package Graphs;

public class NumberOfIslands {

    static class Solution {
        public int numIslands(char[][] grid) {
            int row = grid.length;
            int column = grid[0].length;
            int islands = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] == '1') {
                        islands++;
                        dfs(i, j, grid);
                    }
                }
            }
            return islands;
        }

        private void dfs(int row, int column, char[][] grid) {
            int newRow = grid.length;
            int newColumn = grid[0].length;
            if (row < 0 || column < 0 || row >= newRow || column >= newColumn || grid[row][column] == '0')
                return;

            // Mark current cell as visited
            grid[row][column] = '0';

            // Explore all 4 directions: right, down, left, up
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] dir : direction) {
                dfs(row + dir[0], column + dir[1], grid);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] grid2 = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };

        System.out.println("Number of Islands (grid1): " + sol.numIslands(grid1));  // Output: 3
        System.out.println("Number of Islands (grid2): " + sol.numIslands(grid2));  // Output: 1
    }
}