package Queue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> in, out;

    public ImplementQueueUsingStacks() {
        // Initialize the two stacks
        in = new Stack<>();
        out = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from the front of queue
    public int pop() {
        // Make sure the out stack is populated before popping
        peek();
        return out.pop();
    }

    // Get the front element
    public int peek() {
        // Transfer elements from in to out if out is empty
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    // Main method to test the MyQueue class
    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();

        // Test case 1: Push elements and perform operations
        obj.push(1);
        obj.push(2);
        System.out.println("Peek: " + obj.peek());   // Output: 1
        System.out.println("Pop: " + obj.pop());     // Output: 1
        System.out.println("Peek: " + obj.peek());   // Output: 2
        System.out.println("Is Empty? " + obj.empty()); // Output: false

        // Test case 2: Pop element and check if the queue is empty
        obj.push(3);
        System.out.println("Pop: " + obj.pop());     // Output: 2
        System.out.println("Is Empty? " + obj.empty()); // Output: false
    }
}

