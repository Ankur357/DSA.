package Queue;


import java.util.PriorityQueue;
import java.util.Arrays;

public class KClosestPoints {

    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
            );

            for (int[] point : points) {
                maxHeap.add(point);
                if (maxHeap.size() > k) maxHeap.poll();
            }

            int[][] res = new int[k][2];
            for (int i = 0; i < k; i++) {
                res[i] = maxHeap.poll();
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points1 = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k1 = 2;

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;

        System.out.println("K closest points (k=2): " + Arrays.deepToString(sol.kClosest(points1, k1)));
        System.out.println("K closest points (k=2): " + Arrays.deepToString(sol.kClosest(points2, k2)));
    }
}

