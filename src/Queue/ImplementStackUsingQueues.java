package Queue;

import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // Push the new element to q1
        q1.offer(x);
        // Move all elements back from q2 to q1
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        // Remove the element from the front of q1 (simulating stack pop)
        return q1.poll();
    }

    public int top() {
        // Return the front element of q1 without removing it (simulating stack peek)
        return q1.peek();
    }

    public boolean empty() {
        // Check if q1 is empty
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();

        // Testing the stack operations
        obj.push(10);
        obj.push(20);
        obj.push(30);
        System.out.println("Top element: " + obj.top());  // Expected: 30

        System.out.println("Pop element: " + obj.pop());  // Expected: 30
        System.out.println("Top element after pop: " + obj.top());  // Expected: 20

        obj.push(40);
        System.out.println("Top element after push 40: " + obj.top());  // Expected: 40

        System.out.println("Is stack empty? " + obj.empty());  // Expected: false
        System.out.println("Pop element: " + obj.pop());  // Expected: 40
        System.out.println("Pop element: " + obj.pop());  // Expected: 20

        System.out.println("Is stack empty after pops? " + obj.empty());  // Expected: true
    }
}

