package stack.application;

import ds.stack.core.LinkedStack;

public class ReversalUsingLinkedStack {

	public static void reverse(int[] array, LinkedStack stack) {
		for (int n : array) {
			stack.push(n);
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}
}
