package LinkedList;

public class LinkedListCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect cycle
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Build list: 3 -> 2 -> 0 -> -4
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create cycle: -4 -> 2
        node4.next = node2;

        System.out.println("Cycle present? " + hasCycle(head)); // true

        // Non-cycle example
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Cycle present? " + hasCycle(head2)); // false
    }
}

