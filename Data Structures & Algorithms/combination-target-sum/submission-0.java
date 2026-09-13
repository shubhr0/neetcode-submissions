class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        List<Integer> current = new ArrayList<>();
        backtrack(0,0,current);
        return list;
    }

    public void backtrack(int index,int count,List<Integer> current){
        if(count == target){
            list.add(new ArrayList<>(current));
            return;
        }
        if(count>target){
            return;
        }
        if(index==nums.length){
            return;
        }
        count += nums[index];
        current.add(nums[index]);
        backtrack(index,count,current);
        count -= nums[index];
        current.remove(current.size()-1);
        backtrack(index+1,count,current);

    }
}
