class MedianFinder {

    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(maxHeap.size() !=0 && minHeap.size() != 0 && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        } 

        if(minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }

        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }

        else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        else {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
