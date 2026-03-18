package Graphs;

import java.util.*;

public class CourseScheduleII {

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // Step 1: Create the adjacency list
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.put(i, new ArrayList<>());
            }

            // Step 2: Build the graph from prerequisites
            for (int[] pre : prerequisites) {
                adjList.get(pre[1]).add(pre[0]);
            }

            // Step 3: Initialize visited array and a stack for the result
            int[] visited = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited
            Stack<Integer> st = new Stack<>();

            // Step 4: Perform DFS for each course
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0) {
                    if (!dfs(i, adjList, visited, st)) {
                        return new int[0];  // If a cycle is detected, return empty array
                    }
                }
            }

            // Step 5: Convert stack to result array
            int[] result = new int[numCourses];
            int index = 0;
            while (!st.isEmpty()) {
                result[index++] = st.pop();  // Pop from the stack to get topological order
            }

            return result;
        }

        // Step 6: DFS function to check for cycles and generate topological sort
        private boolean dfs(int course, Map<Integer, List<Integer>> adjList,
                            int[] visited, Stack<Integer> st) {
            // If the course is being visited in the current DFS path, a cycle is found
            if (visited[course] == 1) return false;

            // If the course has already been fully processed, skip it
            if (visited[course] == 2) return true;

            // Mark the course as visiting
            visited[course] = 1;

            // Visit all the prerequisites (neighbors)
            for (int neighbor : adjList.get(course)) {
                if (!dfs(neighbor, adjList, visited, st)) return false;  // Cycle detected
            }

            // Mark the course as fully processed
            visited[course] = 2;

            // Add the course to the stack (topologically sorted order)
            st.push(course);

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
        int numCourses1 = 4;
        System.out.println("Course Order (Example 1): " + Arrays.toString(sol.findOrder(numCourses1, prerequisites1)));
        // Output: [0, 1, 2, 3] or any valid order

        // Example 2 (Cycle exists, cannot finish courses)
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int numCourses2 = 2;
        System.out.println("Course Order (Example 2): " + Arrays.toString(sol.findOrder(numCourses2, prerequisites2)));
        // Output: []

        // Example 3 (Multiple valid answers)
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses3 = 4;
        System.out.println("Course Order (Example 3): " + Arrays.toString(sol.findOrder(numCourses3, prerequisites3)));
        // Output: [0, 1, 2, 3] or any valid order
    }
}
