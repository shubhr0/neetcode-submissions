class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int num : nums){
            maxheap.offer(num);
        }
        for(int i=1;i<k;i++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
}
