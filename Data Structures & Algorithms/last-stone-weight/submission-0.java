class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            mh.add(stone);
        }

        while (mh.size() > 1) {
            int y = mh.poll(); // largest
            int x = mh.poll(); // second largest

            if (y != x) {
                mh.add(y - x);
            }
        }

        return mh.isEmpty() ? 0 : mh.peek();
    }
}
