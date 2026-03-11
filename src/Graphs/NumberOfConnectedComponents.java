package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {

    static class Solution {
        public int countComponents(int n, int[][] edges) {
            List<List<Integer>> adjList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[n];
            int components = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, adjList, visited);
                    components++;
                }
            }

            return components;
        }

        private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
            visited[node] = true;

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, adjList, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 5;
        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        int n2 = 5;
        int[][] edges2 = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println("Connected Components (Example 1): " + sol.countComponents(n1, edges1)); // 2
        System.out.println("Connected Components (Example 2): " + sol.countComponents(n2, edges2)); // 1
    }
}