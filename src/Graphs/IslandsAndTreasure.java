package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {

    static class Solution {
        public void islandsAndTreasure(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return;

            int INF = 2147483647; // Represent land cells
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();

            // Step 1: Initialize grid and add treasure cells (0) to the queue
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        queue.add(new int[]{i, j}); // Add treasure chest positions to the queue
                    } else if (grid[i][j] != -1) {
                        grid[i][j] = INF; // Set all land cells to INF initially
                    }
                }
            }

            // Directions for up, down, left, and right movements
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            // Step 2: Perform BFS to fill the grid with the minimum distances
            while (!queue.isEmpty()) {
                int[] chest = queue.poll();
                int row = chest[0];
                int col = chest[1];

                // Explore all 4 possible directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Only update the cell if it's a land cell (INF)
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == INF) {
                        // Update with the shortest distance
                        grid[newRow][newCol] = grid[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol}); // Add to queue for further processing
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example grid with land (INF), treasure (0), and obstacles (-1)
        int[][] grid = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        // Print the grid before processing
        System.out.println("Grid before processing:");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print((cell == Integer.MAX_VALUE ? "INF" : cell) + " ");
            }
            System.out.println();
        }

        // Run the function to update the grid with distances to nearest treasure chest
        sol.islandsAndTreasure(grid);

        // Print the updated grid with distances
        System.out.println("\nGrid after processing:");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print((cell == Integer.MAX_VALUE ? "INF" : cell) + " ");
            }
            System.out.println();
        }
    }
}