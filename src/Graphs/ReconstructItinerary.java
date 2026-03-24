package Graphs;

import java.util.*;

public class ReconstructItinerary {

    static class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, List<String>> graph = new HashMap<>();
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            }

            // Sort destinations lexically
            for (List<String> destinations : graph.values()) {
                Collections.sort(destinations);
            }

            LinkedList<String> itinerary = new LinkedList<>();
            dfs("JFK", graph, itinerary);
            return itinerary;
        }

        private void dfs(String src, Map<String, List<String>> graph, LinkedList<String> result) {
            List<String> dest = graph.get(src);
            while (dest != null && !dest.isEmpty()) {
                String next = dest.remove(0); // remove first destination
                dfs(next, graph, result);
            }
            result.addFirst(src); // build itinerary in reverse
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        List<String> itinerary = sol.findItinerary(tickets);
        System.out.println("Reconstructed Itinerary: " + itinerary);
        // Expected Output: [JFK, ATL, JFK, SFO, ATL, SFO]
    }
}