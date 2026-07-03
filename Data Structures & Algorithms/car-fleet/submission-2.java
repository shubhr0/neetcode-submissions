class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack =new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<position.length;i++){
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        for(int i=0;i<position.length;i++){
            double time = (double)(target - position[i]) / map.get(position[i]);
            stack.push(time);
        }
        int count=0;
        double val=0;
        while(!stack.isEmpty()){
            if(stack.peekFirst()>val){
                val=stack.pop();
                count++;
                continue;
            }
            stack.pop();
        }
        return count;
    }
}
