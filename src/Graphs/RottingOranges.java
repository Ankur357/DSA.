package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    static class Solution {
        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0) return -1;

            int m = grid.length;
            int n = grid[0].length;
            int freshOranges = 0;
            Queue<int[]> queue = new LinkedList<>();

            // Step 1: Count fresh oranges and add rotten oranges to the queue
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) freshOranges++;  // Count fresh oranges
                    else if (grid[i][j] == 2) queue.offer(new int[]{i, j});  // Rotten oranges in the queue
                }
            }

            // If there are no fresh oranges initially, return 0
            if (freshOranges == 0) return 0;

            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // Directions: right, down, left, up
            int minutes = 0;

            // Step 2: Perform BFS until all oranges rot or it's impossible
            while (!queue.isEmpty() && freshOranges > 0) {
                int size = queue.size();

                // Process each level of BFS (one minute)
                for (int i = 0; i < size; i++) {
                    int[] rotten = queue.poll();

                    // Check all 4 directions for fresh oranges
                    for (int[] dir : directions) {
                        int x = rotten[0] + dir[0];
                        int y = rotten[1] + dir[1];

                        // If the position is valid and contains a fresh orange, rot it
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                            grid[x][y] = 2;  // Mark the orange as rotten
                            freshOranges--;    // Decrease fresh orange count
                            queue.offer(new int[]{x, y});  // Add the newly rotten orange to the queue
                        }
                    }
                }

                // Increase minute count after processing this level
                minutes++;
            }

            // Step 3: If there are still fresh oranges, return -1 (impossible to rot all)
            return freshOranges == 0 ? minutes : -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Grid with some fresh and rotten oranges
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test Case 1: " + sol.orangesRotting(grid1));  // Output: 4

        // Test Case 2: Some fresh oranges can't rot (isolated)
        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("Test Case 2: " + sol.orangesRotting(grid2));  // Output: -1

        // Test Case 3: No fresh oranges, so 0 minutes required
        int[][] grid3 = {
                {0, 2}
        };
        System.out.println("Test Case 3: " + sol.orangesRotting(grid3));  // Output: 0

        // Test Case 4: All fresh oranges rot in the minimum number of minutes
        int[][] grid4 = {
                {1, 2, 1},
                {1, 1, 1},
                {2, 1, 2}
        };
        System.out.println("Test Case 4: " + sol.orangesRotting(grid4));  // Output: 2
    }
}