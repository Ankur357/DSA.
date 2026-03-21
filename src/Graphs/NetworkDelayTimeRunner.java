package Graphs;

import java.util.*;

public class NetworkDelayTimeRunner {

    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : times) {
                graph.computeIfAbsent(edge[0], x -> new ArrayList<>())
                        .add(new int[]{edge[1], edge[2]});
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            queue.offer(new int[]{k, 0});

            int[] distances = new int[n + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[k] = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentNode = current[0];
                int currentDistance = current[1];

                if (currentDistance > distances[currentNode]) continue;

                if (graph.containsKey(currentNode)) {
                    for (int[] neighbor : graph.get(currentNode)) {
                        int nextNode = neighbor[0];
                        int nextDistance = currentDistance + neighbor[1];
                        if (nextDistance < distances[nextNode]) {
                            distances[nextNode] = nextDistance;
                            queue.offer(new int[]{nextNode, nextDistance});
                        }
                    }
                }
            }

            int maxDist = Arrays.stream(distances).skip(1).max().getAsInt();
            return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;

        int result = sol.networkDelayTime(times, n, k);
        System.out.println("Network delay time: " + result); // Output: 2
    }
}