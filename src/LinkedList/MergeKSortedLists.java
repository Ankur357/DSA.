package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (ListNode list : lists) {
                while (list != null) {
                    minHeap.add(list.val);
                    list = list.next;
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode merge = dummy;

            while (!minHeap.isEmpty()) {
                merge.next = new ListNode(minHeap.poll());
                merge = merge.next;
            }

            return dummy.next;
        }
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // List 1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));

        // List 2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // List 3: 2 -> 6
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        Solution sol = new Solution();
        ListNode merged = sol.mergeKLists(lists);

        System.out.println("Merged List:");
        printList(merged);
    }
}

