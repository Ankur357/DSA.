package Queue;


import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TaskScheduler {

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] freq = new int[26];

            for (char task : tasks) {
                freq[task - 'A']++;
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0)
                    maxHeap.add(freq[i]);
            }

            int time = 0;

            while (!maxHeap.isEmpty()) {
                int cycle = n + 1;
                List<Integer> list = new ArrayList<>();
                int taskCount = 0;

                while (cycle-- > 0 && !maxHeap.isEmpty()) {
                    int currentFreq = maxHeap.poll();
                    if (currentFreq > 1) {
                        list.add(currentFreq - 1);
                    }
                    taskCount++;
                }

                list.forEach(maxHeap::offer);

                time += (maxHeap.isEmpty() ? taskCount : n + 1);
            }

            return time;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;

        char[] tasks2 = {'A','A','A','B','B','B'};
        int n2 = 0;

        char[] tasks3 = {'A','A','A','A','B','C','D','E'};
        int n3 = 2;

        System.out.println("Input: " + Arrays.toString(tasks1) + ", n = " + n1);
        System.out.println("Output: " + sol.leastInterval(tasks1, n1));

        System.out.println("\nInput: " + Arrays.toString(tasks2) + ", n = " + n2);
        System.out.println("Output: " + sol.leastInterval(tasks2, n2));

        System.out.println("\nInput: " + Arrays.toString(tasks3) + ", n = " + n3);
        System.out.println("Output: " + sol.leastInterval(tasks3, n3));
    }
}

