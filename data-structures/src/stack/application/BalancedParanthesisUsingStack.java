package stack.application;

import ds.stack.core.CharArrayStack;

public class BalancedParanthesisUsingStack {

	public static boolean isBalanced(char[] array, CharArrayStack stack) {
		for (char c : array) {
			switch (c) {
			case '{':
				stack.push(c);
				break;
			case '}':
				if (!stack.isEmpty() && stack.top() == '{') {
					stack.pop();
				} else {
					stack.push(c);
				}
				break;
			case '(':
				stack.push(c);
				break;
			case ')':
				if (!stack.isEmpty() && stack.top() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
				break;
			case '[':
				stack.push(c);
				break;
			case ']':
				if (!stack.isEmpty() && stack.top() == '[') {
					stack.pop();
				} else {
					stack.push(c);
				}
				break;
			default:
				break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
