class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;

        Arrays.sort(nums);

        List<Integer> current = new ArrayList<>();
        backtrack(0, current);

        return list;
    }

    public void backtrack(int level, List<Integer> current) {

        list.add(new ArrayList<>(current));

        for (int i = level; i < nums.length; i++) {

            if (i > level && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            backtrack(i + 1, current);

            current.remove(current.size() - 1);
        }
    }
}