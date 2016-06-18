package ds.stack.application;

import ds.stack.core.CharArrayStack;

public class ReversalUsingStack {

	public static void reverse(char[] array) {
		CharArrayStack arrayStack = new CharArrayStack(array.length);
		for (char c : array) {
			arrayStack.push(c);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = arrayStack.pop();
		}
	}
}
