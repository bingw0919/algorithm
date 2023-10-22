package zuochengyun_new.class04;


import java.util.Stack;

public class Code04_LinkedListToStack {

    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
            next = null;
        }
    }

    public static class MyStack<V> {
        private Node<V> head;
        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(V value) {
            Node<V> node = new Node<>(value);
            if (size == 0) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
			size++;
        }

        public V pop() {
            if (size == 0) return null;
            Node<V> node = head;
            head = head.next;
            size--;
            return node.value;
        }

        public V peek() {
            if (size == 0) return null;
            return head.value;
        }



    }
	public static void testStack() {
		MyStack<Integer> myStack = new MyStack<>();
		Stack<Integer> test = new Stack<>();
		int testTime = 5000000;
		int maxValue = 200000000;
		System.out.println("测试开始！");
		for (int i = 0; i < testTime; i++) {
			if (myStack.isEmpty() != test.isEmpty()) {
				System.out.println("Oops!");
			}
			if (myStack.size() != test.size()) {
				System.out.println("Oops!");
			}
			double decide = Math.random();
			if (decide < 0.33) {
				int num = (int) (Math.random() * maxValue);
				myStack.push(num);
				test.push(num);
			} else if (decide < 0.66) {
				if (!myStack.isEmpty()) {
					int num1 = myStack.pop();
					int num2 = test.pop();
					if (num1 != num2) {
						System.out.println("Oops!");
					}
				}
			} else {
				if (!myStack.isEmpty()) {
					int num1 = myStack.peek();
					int num2 = test.peek();
					if (num1 != num2) {
						System.out.println("Oops!");
					}
				}
			}
		}
		if (myStack.size() != test.size()) {
			System.out.println("Oops!");
		}
		while (!myStack.isEmpty()) {
			int num1 = myStack.pop();
			int num2 = test.pop();
			if (num1 != num2) {
				System.out.println("Oops!");
			}
		}
		System.out.println("测试结束！");
	}
	public static void main(String[] args) {
		testStack();
	}
}
