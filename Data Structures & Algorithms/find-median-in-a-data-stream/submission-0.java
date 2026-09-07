class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder()); 
        big = new PriorityQueue<>();                            
    }

    public void addNum(int num) {

        small.offer(num);

        big.offer(small.poll());

        if (big.size() > small.size()) {
            small.offer(big.poll());
        }
    }

    public double findMedian() {

        if (small.size() > big.size()) {
            return small.peek();
        }

        return (small.peek() + big.peek()) / 2.0;
    }
}