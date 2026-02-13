package LinkedList;

public class ReverseKGroup {

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

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode temp = head;
            ListNode prevNode = null;

            while (temp != null) {
                ListNode kthNode = findKthNode(temp, k);

                if (kthNode == null) {
                    if (prevNode != null) prevNode.next = temp;
                    break;
                }

                ListNode nextNode = kthNode.next;
                kthNode.next = null;

                reverse(temp);

                if (temp == head) head = kthNode;
                else prevNode.next = kthNode;

                prevNode = temp;
                temp = nextNode;
            }

            return head;
        }

        public ListNode findKthNode(ListNode temp, int k) {
            while (temp != null && --k > 0) {
                temp = temp.next;
            }
            return temp;
        }

        public ListNode reverse(ListNode temp) {
            ListNode prev = null, curr = temp, next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.println("Original list:");
        printList(head);

        Solution sol = new Solution();
        head = sol.reverseKGroup(head, 2);

        System.out.println("\nAfter reversing in groups of 2:");
        printList(head);
    }
}

