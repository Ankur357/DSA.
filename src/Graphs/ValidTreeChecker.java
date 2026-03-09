package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ValidTreeChecker {

    static class Solution {
        public boolean validTree(int n, int[][] edges) {

            if (edges.length != n - 1) return false;

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[n];
            dfs(0, adjList, visited);

            for (boolean vis : visited) {
                if (!vis) return false;
            }
            return true;
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

        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        int n1 = 5;
        System.out.println("Is valid tree (Example 1)? " + sol.validTree(n1, edges1)); // true

        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        int n2 = 5;
        System.out.println("Is valid tree (Example 2)? " + sol.validTree(n2, edges2)); // false

        int[][] edges3 = {{0,1},{2,3}};
        int n3 = 4;
        System.out.println("Is valid tree (Example 3)? " + sol.validTree(n3, edges3)); // false
    }
}