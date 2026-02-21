package Queue;


import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);  // Min-heap to store the top k largest elements
        this.k = k;
        for (int num : nums) add(num);  // Add elements from the input array to the heap
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);  // If the heap has less than k elements, add the new value
        } else if (val > minHeap.peek()) {
            minHeap.poll();  // Remove the smallest (root of the min-heap)
            minHeap.offer(val);  // Add the new value
        }
        return minHeap.peek();  // The root of the min-heap is the kth largest element
    }

    public static void main(String[] args) {
        // Example usage of the KthLargest class
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargest obj = new KthLargest(k, nums);

        // Adding values and printing the current kth largest element after each addition
        System.out.println(obj.add(3));  // Returns 4
        System.out.println(obj.add(5));  // Returns 5
        System.out.println(obj.add(10)); // Returns 5
        System.out.println(obj.add(9));  // Returns 8
        System.out.println(obj.add(4));  // Returns 8
    }
}

