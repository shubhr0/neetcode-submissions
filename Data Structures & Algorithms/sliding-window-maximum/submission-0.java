class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left=0;

        ArrayList<Integer> list = new ArrayList<>();
        while(left!=nums.length - k + 1){
            int val=nums[left];
            for(int right=left;right<=left+k-1;right++){
                if(nums[right]>val){
                    val=nums[right];
                }
            }
            list.add(val);
            left++;
        }
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
        
    }
}
