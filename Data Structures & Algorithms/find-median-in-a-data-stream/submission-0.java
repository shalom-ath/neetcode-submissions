public class MedianFinder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public void addNum(int num) {

        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size())

        maxHeap.offer(minHeap.poll());
        
    }
    
    public double findMedian() {

        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
        
    }
}
