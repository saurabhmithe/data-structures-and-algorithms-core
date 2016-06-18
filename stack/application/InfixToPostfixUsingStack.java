package ds.stack.application;

import ds.stack.core.CharArrayStack;

public class InfixToPostfixUsingStack {
	public static String convert(char[] array, CharArrayStack stack) {
		char[] postfixExpression = new char[array.length];

		int i = 0;
		for (char c : array) {
			if (c == '+' || c == '-') {
				if (stack.top() == '*' || stack.top() == '/') {
					postfixExpression[i++] = stack.pop();
					stack.push(c);
				} else {
					stack.push(c);
				}
			} else if (c == '*' || c == '/') {
				stack.push(c);
			} else {
				postfixExpression[i++] = c;
			}
		}

		while (!stack.isEmpty()) {
			char c = stack.pop();
			postfixExpression[i] = c;
			i++;
		}
		String finalExpression = new String(postfixExpression);
		return finalExpression;
	}
}
