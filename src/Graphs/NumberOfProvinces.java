package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    static class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int provinces = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    bfs(isConnected, visited, i);
                    provinces++;
                }
            }
            return provinces;
        }

        private void bfs(int[][] isConnected, boolean[] visited, int start) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            while (!queue.isEmpty()) {
                int city = queue.poll();
                for (int i = 0; i < isConnected.length; i++) {
                    if (isConnected[city][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + sol.findCircleNum(isConnected1));  // Output: 2

        // Example 2
        int[][] isConnected2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + sol.findCircleNum(isConnected2));  // Output: 3
    }
}