package LinkedList;

import java.util.HashMap;

public class CopyRandomList {

    // Definition for a Node
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;

            HashMap<Node, Node> map = new HashMap<>();

            Node curr = head;
            while (curr != null) {
                map.put(curr, new Node(curr.val));
                curr = curr.next;
            }

            curr = head;
            while (curr != null) {
                Node copy = map.get(curr);
                copy.next = map.get(curr.next);
                copy.random = map.get(curr.random);
                curr = curr.next;
            }

            return map.get(head);
        }
    }

    // Helper to print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node: " + temp.val + ", Random: " + randomVal);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Create example list:
        // 7 -> 13 -> 11 -> 10 -> 1
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        System.out.println("Original list:");
        printList(n1);

        Solution sol = new Solution();
        Node copiedHead = sol.copyRandomList(n1);

        System.out.println("\nCopied list:");
        printList(copiedHead);
    }
}

