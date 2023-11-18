package zuochengyun_system.class03;

import java.util.Stack;

public class Code05_TwoStacksImplementQueue {
	private Stack<Integer> stack1;
	//用于出栈实现队列
	private Stack<Integer> stack2;
	public Code05_TwoStacksImplementQueue(){
		stack1=new Stack<>();
		stack2=new Stack<>();
	}
	public void push(int x) {
		stack1.push(x);
	}

	public int pop() {
		if(stack2.isEmpty()){
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int peek() {
		if(stack2.isEmpty()){
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public boolean empty() {
		return stack1.isEmpty()&& stack2.isEmpty();
	}

	public static void main(String[] args) {
		Code05_TwoStacksImplementQueue queue = new Code05_TwoStacksImplementQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}
}
