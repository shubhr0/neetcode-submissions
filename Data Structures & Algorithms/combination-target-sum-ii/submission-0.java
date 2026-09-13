class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] candidates;
    int count=0;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target=target;
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        backtrack(0,current,count);
        return list;
    }
    public void backtrack(int index,List<Integer> current,int count){
        if(count==target){
            list.add(new ArrayList<>(current));
            return;
        }
        if(count>target){
            return;
        }
        
        for(int i=index;i<candidates.length;i++){

            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }

            count += candidates[i];
            current.add(candidates[i]);
            backtrack(i+1,current,count);

            count -= candidates[i];
            current.remove(current.size()-1);

        }
    }
}
