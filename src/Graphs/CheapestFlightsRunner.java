package Graphs;

import java.util.*;

public class CheapestFlightsRunner {

    static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[] costs = new int[n];
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[src] = 0;

            for (int i = 0; i <= k; i++) {
                int[] temp = costs.clone();
                for (int[] flight : flights) {
                    int u = flight[0];
                    int v = flight[1];
                    int w = flight[2];

                    if (costs[u] == Integer.MAX_VALUE) continue;

                    if (temp[v] > costs[u] + w) {
                        temp[v] = costs[u] + w;
                    }
                }
                costs = temp;
            }

            return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;

        int result = sol.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest Price: " + result); // Output: 200
    }
}
