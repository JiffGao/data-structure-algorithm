package queue;

public class ArrayStackDemo {

}

class ArrayStack {
	private int top = -1;
	private int bottom = -1;
	private int[] stack;
	private int maxSize;

	public ArrayStack(int size) {
		this.maxSize = size;
		stack = new int[size];
	}

	// push a value
	public void push(int value) {
		if (isFull()) {
			System.out.println("stack is full");
			return;
		}
		if (isEmpty()) {
			bottom++;
		}
		top++;
		stack[top] = value;
	}

	// pop a value
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty!");
		}
		int cur = stack[top];
		if (top == 0) {
			bottom--;
		}
		top--;
		return cur;
	}

	// peek the top value
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("the stack is empty!");
		}
		return stack[top];
	}

	// 规定优先级compare
	public int priority(char ch) {
		if (ch == '*' || ch == '/') {
			return 1;
		} else if (ch == '+' || ch == '-') {
			return 0;
		} else {
			throw new RuntimeException("不支持的运算符");
		}
	}

	private boolean isEmpty() {
		if (top == bottom) {
			return true;
		}
		return false;
	}

	private boolean isFull() {
		if (top == maxSize - 1) {
			return true;
		}
		return false;
	}
}