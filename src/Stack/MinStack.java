package Stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        min.push(min.isEmpty() ? val : Math.min(val, min.peek()));
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

 class Main {
    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(3);
        obj.push(4);
        obj.push(2);
        obj.push(1);

        System.out.println("Top element: " + obj.top());
        System.out.println("Minimum element: " + obj.getMin());

        obj.pop();
        System.out.println("Top element after pop: " + obj.top());
        System.out.println("Minimum element after pop: " + obj.getMin());

        obj.pop();
        System.out.println("Top element after pop: " + obj.top());
        System.out.println("Minimum element after pop: " + obj.getMin());
    }
}
