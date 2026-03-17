package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // Build the graph using a HashMap
            HashMap<Integer, List<Integer>> courseMap = new HashMap<>();

            for (int[] pre : prerequisites) {
                // If the prerequisite already exists, add the course to the list
                if (courseMap.containsKey(pre[1])) {
                    courseMap.get(pre[1]).add(pre[0]);
                } else {
                    // Otherwise, create a new list for the prerequisites
                    List<Integer> list = new LinkedList<>();
                    list.add(pre[0]);
                    courseMap.put(pre[1], list);
                }
            }

            // Set to keep track of visited nodes during DFS
            HashSet<Integer> visited = new HashSet<>();

            // Check if each course can be completed without a cycle
            for (int curr = 0; curr < numCourses; curr++) {
                if (!courseVisited(curr, visited, courseMap)) {
                    return false;  // Cycle detected
                }
            }
            return true;  // No cycles detected
        }

        // Helper function for DFS traversal to check for cycles
        private boolean courseVisited(int curr, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseMap) {
            // If the course is already in the visited set, it means we found a cycle
            if (visited.contains(curr)) {
                return false;
            }
            // If the course has no prerequisites (already processed), return true
            if (courseMap.get(curr) == null) {
                return true;
            }

            // Mark the current course as visited in the DFS path
            visited.add(curr);

            // Visit all the prerequisites for the current course
            for (int pre : courseMap.get(curr)) {
                if (!courseVisited(pre, visited, courseMap)) {
                    return false;  // Cycle detected in the prerequisites
                }
            }

            // After processing, mark the course as fully visited by setting its list to null
            visited.remove(curr);
            courseMap.put(curr, null);  // Nullifying the list indicates that the course is fully processed
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: No cycles
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        int numCourses1 = 4;
        System.out.println("Can finish courses (Example 1)? " + sol.canFinish(numCourses1, prerequisites1)); // true

        // Test case 2: Contains a cycle
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int numCourses2 = 2;
        System.out.println("Can finish courses (Example 2)? " + sol.canFinish(numCourses2, prerequisites2)); // false
    }
}
