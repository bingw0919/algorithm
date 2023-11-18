package zuochengyun_system.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code06_TwoQueueImplementStack {
	private final Queue<Integer> queue1;
	private final Queue<Integer> queue2;

	public Code06_TwoQueueImplementStack() {
		queue1=new LinkedList<>();
		queue2=new LinkedList<>();
	}

	public void push(int x) {
		if(queue1.isEmpty()&&queue2.isEmpty()){
			queue1.offer(x);
			return;
		}
		if(!queue1.isEmpty()) queue1.offer(x);
		if(!queue2.isEmpty()) queue2.offer(x);
	}

	public int pop() {
		if(queue1.size()==1) return queue1.poll();
		if(queue2.size()==1) return queue2.poll();
		int ans=0;
		//判断q1是否有元素
		if(!queue1.isEmpty()){
			while (queue1.size()!=1){
				queue2.offer(queue1.poll());
			}
			ans=queue1.poll();
		}else {
			while (queue2.size()!=1){
				queue1.offer(queue2.poll());
			}
			ans=queue2.poll();
		}
		return ans;
	}

	public int top() {
		if(queue1.size()==1) return queue1.peek();
		if(queue2.size()==1) return queue2.peek();
		int ans=0;
		//判断q1是否有元素
		if(!queue1.isEmpty()){
			while (queue1.size()!=1){
				queue2.offer(queue1.poll());
			}
			ans=queue1.poll();
			queue2.offer(ans);
		}else {
			while (queue2.size()!=1){
				queue1.offer(queue2.poll());
			}
			ans=queue2.poll();
			queue1.offer(ans);
		}
		return ans;
	}

	public boolean empty() {
		return queue1.isEmpty()&&queue2.isEmpty();
	}

	public static void main(String[] args) {
		Code06_TwoQueueImplementStack stack = new Code06_TwoQueueImplementStack();
		stack.push(1);
		stack.pop();
		stack.empty();
	}

}
