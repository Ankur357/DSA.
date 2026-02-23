package Queue;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    // Constructor to initialize heaps
    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // Min-heap for larger half
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap for smaller half
    }

    // Add number to the data structure
    public void addNum(int num) {
        maxHeap.offer(num);  // Offer to maxHeap
        minHeap.offer(maxHeap.poll());  // Move the largest of maxHeap to minHeap

        // Balance the sizes of heaps (maxHeap can have at most one extra element)
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());  // Move the smallest of minHeap back to maxHeap
        }
    }

    // Find the current median
    public double findMedian() {
        // If maxHeap has more elements, the median is the top of maxHeap
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // If both heaps have equal size, median is the average of the tops of both heaps
        return (maxHeap.peek() + minHeap.peek()) * 0.5;
    }

    // Main method to test the MedianFinder class
    public static void main(String[] args) {
        // Create a new instance of MedianFinder
        MedianFinder obj = new MedianFinder();

        // Add numbers to the MedianFinder object
        obj.addNum(1);
        obj.addNum(2);
        System.out.println("Median after adding 1, 2: " + obj.findMedian());  // Output: 1.5

        obj.addNum(3);
        System.out.println("Median after adding 3: " + obj.findMedian());  // Output: 2.0

        obj.addNum(4);
        System.out.println("Median after adding 4: " + obj.findMedian());  // Output: 2.5
    }
}
