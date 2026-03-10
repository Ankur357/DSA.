package Graphs;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnectionFinder {

    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            int[] parent = new int[n + 1];

            // Initialize parent array
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            // Process edges and apply Union-Find
            for (int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];

                int root1 = find(parent, node1);
                int root2 = find(parent, node2);

                if (root1 == root2) {
                    return edge;  // Found the redundant connection
                }

                // Union the two nodes
                parent[root2] = root1;
            }

            return new int[0];  // No redundant connection
        }

        private int find(int[] parent, int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];  // Path compression
                node = parent[node];
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println("Redundant Connection (Example 1): ");
        int[] result1 = sol.findRedundantConnection(edges1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // [2, 3]

        // Example 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}};
        System.out.println("Redundant Connection (Example 2): ");
        int[] result2 = sol.findRedundantConnection(edges2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // [1, 4]

        // Example 3
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {2, 5}};
        System.out.println("Redundant Connection (Example 3): ");
        int[] result3 = sol.findRedundantConnection(edges3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // [2, 5]
    }
}