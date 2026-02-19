package Queue;


import java.util.PriorityQueue;
import java.util.Arrays;

public class LastStoneWeight {

    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

            for (int stone : stones) {
                queue.offer(stone);
            }

            while (queue.size() > 1) {
                int val1 = queue.poll();
                int val2 = queue.poll();
                if (val1 != val2) {
                    queue.offer(val1 - val2);
                }
            }

            return queue.isEmpty() ? 0 : queue.poll();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};
        int[] stones3 = {9, 3, 2, 10};

        System.out.println("Input: " + Arrays.toString(stones1));
        System.out.println("Output: " + sol.lastStoneWeight(stones1));

        System.out.println("\nInput: " + Arrays.toString(stones2));
        System.out.println("Output: " + sol.lastStoneWeight(stones2));

        System.out.println("\nInput: " + Arrays.toString(stones3));
        System.out.println("Output: " + sol.lastStoneWeight(stones3));
    }
}

