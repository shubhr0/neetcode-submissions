class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int[] store = new int[k];
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> maxEntry = null;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxEntry == null ||
                    entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }

            store[i] = maxEntry.getKey();
            map.remove(maxEntry.getKey());
        }
        return store;

    }
}
