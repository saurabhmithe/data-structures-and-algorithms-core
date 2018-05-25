package stack.core;

public class CharArrayStack {
	private char[] array;
	private int top;
	private int size;
	private boolean error;
	private String errorDescription;

	public CharArrayStack(int size) {
		this.size = size;
		array = new char[size];
		top = -1;
	}

	public void push(char data) {
		if ((top + 1) < size) {
			array[++top] = data;
		} else {
			error = true;
			errorDescription = "Stack is full. Unable to push.";
		}
	}

	public char pop() {
		if (!isEmpty()) {
			return array[top--];
		} else {
			error = true;
			errorDescription = "Stack is empty. Unable to pop.";
			return 'x';
		}
	}

	public int top() {
		return array[top];
	}

	public void print() {
		for (int i = 0; i <= top; i++) {
			System.out.println(array[i]);
		}
	}

	public void printError() {
		System.out.println(errorDescription);
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isError() {
		return error;
	}
}
