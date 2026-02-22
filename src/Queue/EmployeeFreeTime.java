package Queue;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class EmployeeFreeTime {

    // Interval class
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    static class Solution {
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<Interval> result = new ArrayList<>();
            PriorityQueue<Interval> pq =
                    new PriorityQueue<>((a, b) -> a.start - b.start);

            // Add all intervals into min-heap
            for (List<Interval> intervals : schedule) {
                pq.addAll(intervals);
            }

            if (pq.isEmpty()) return result;

            Interval prev = pq.poll();

            while (!pq.isEmpty()) {
                Interval curr = pq.poll();

                if (prev.end < curr.start) {
                    // Found free time
                    result.add(new Interval(prev.end, curr.start));
                    prev = curr;
                } else {
                    // Merge intervals
                    prev.end = Math.max(prev.end, curr.end);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Interval>> schedule = new ArrayList<>();

        schedule.add(Arrays.asList(
                new Interval(1, 2),
                new Interval(5, 6)
        ));

        schedule.add(Arrays.asList(
                new Interval(1, 3)
        ));

        schedule.add(Arrays.asList(
                new Interval(4, 10)
        ));

        System.out.println("Input Schedule:");
        for (List<Interval> employee : schedule) {
            System.out.println(employee);
        }

        List<Interval> freeTime = sol.employeeFreeTime(schedule);

        System.out.println("\nEmployee Free Time:");
        System.out.println(freeTime);
    }
}