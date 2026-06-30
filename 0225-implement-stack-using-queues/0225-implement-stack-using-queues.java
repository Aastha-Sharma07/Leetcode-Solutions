class MyStack {

    Stack<Integer> st;
    public MyStack() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}
