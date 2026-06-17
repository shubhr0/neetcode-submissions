class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> nums1=  new HashSet<>();
        for(int i= 0;i<nums.length;i++){
            if(nums1.contains(nums[i])){
                return true;
            }
            nums1.add(nums[i]);
        }
        return false;
    }
}