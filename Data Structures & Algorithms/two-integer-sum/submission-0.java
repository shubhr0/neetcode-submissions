class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> val=new HashMap<>();
        int searchval=0;
        for(int i = 0; i < nums.length; i++){
            searchval=target-nums[i];
            if(val.containsKey(searchval)){
                return new int[] {val.get(searchval),i};
            }
            val.put(nums[i],i);
        }
        return new int[] {};
    }
}
