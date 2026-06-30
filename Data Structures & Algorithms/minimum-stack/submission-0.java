class MinStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    public MinStack() {
        stack1=new ArrayDeque<>();
        stack2=new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty() || stack2.peek()>=val){
            stack2.push(val);
        }
    }
    
    public void pop() {
        if(stack2.peek().equals(stack1.peek())){
            stack2.pop();
        }
        stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}
