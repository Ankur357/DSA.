package LinkedList;

public class AddTwoNumbers {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            ans.next = new ListNode(sum % 10);
            ans = ans.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // l1 = 2 -> 4 -> 3  (342)
        ListNode l1 = new ListNode(2,
                new ListNode(4,
                        new ListNode(3)));

        // l2 = 5 -> 6 -> 4  (465)
        ListNode l2 = new ListNode(5,
                new ListNode(6,
                        new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Result:");
        printList(result); // 7 -> 0 -> 8
    }
}

