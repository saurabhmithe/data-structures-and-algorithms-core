package ds.stack.application;

import ds.stack.core.ArrayStack;

public class PrefixEvaluation {
	public static int evaluate(char[] array, ArrayStack stack) {
		for (int i = array.length - 1; i >= 0; i--) {
			char c = array[i];
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				stack.push(Character.getNumericValue(c));
			} else {
				int a = stack.pop();
				int b = stack.pop();

				if (c == '+') {
					stack.push(a + b);
				} else if (c == '-') {
					stack.push(Math.max(a, b) - Math.min(a, b));
				} else if (c == '*') {
					stack.push(a * b);
				} else if (c == '/') {
					stack.push(a / b);
				}
			}
		}

		return stack.pop();
	}
}
