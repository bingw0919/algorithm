package zuochengyun_system.class03;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: bing
 * @date: 2023-11-16 19:29
 */
public class Code04_MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Code04_MinStack() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
        }else {
            Integer peek = stack2.peek();
            stack2.push(val<peek?val:peek);
        }
    }

    public void pop() {
        if(stack1.isEmpty()||stack2.isEmpty()) return;
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        if(stack1.isEmpty()) throw new RuntimeException();
        return stack1.peek();
    }

    public int getMin() {
        if(stack2.isEmpty()) throw new RuntimeException();
        return stack2.peek();
    }
}
