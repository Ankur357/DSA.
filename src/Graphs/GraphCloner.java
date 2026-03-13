package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphCloner {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        private HashMap<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null; // Handle null input

            // If the node has already been visited, return the cloned version
            if (visited.containsKey(node)) return visited.get(node);

            // Create a clone for the current node
            Node cloneNode = new Node(node.val, new ArrayList<>());
            visited.put(node, cloneNode);

            // Recursively clone all the neighbors
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }

            return cloneNode;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Clone a simple graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println("Cloning Example 1: ");
        Node clonedGraph = solution.cloneGraph(node1);
        printGraph(clonedGraph);  // Prints the cloned graph

        // You can add more examples or test cases as needed
    }

    // Utility function to print the graph structure
    private static void printGraph(Node node) {
        if (node == null) return;

        System.out.println("Node value: " + node.val);
        System.out.print("Neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        // To avoid infinite loops, we'll use a HashSet to track visited nodes
        HashSet<Node> visited = new HashSet<>();
        visited.add(node);
        printNeighbors(node, visited);
    }

    private static void printNeighbors(Node node, HashSet<Node> visited) {
        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                printGraph(neighbor);
            }
        }
    }
}