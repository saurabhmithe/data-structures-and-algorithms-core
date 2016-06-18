package ds.stack.application;

import ds.stack.core.ArrayStack;

public class PostfixEvaluation {
	public static int evaluate(ArrayStack stack, char[] array) {
		for (char c : array) {
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				stack.push(Character.getNumericValue(c));
			} else {
				int b = stack.pop();
				int a = stack.pop();

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
