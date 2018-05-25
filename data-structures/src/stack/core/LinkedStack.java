package stack.core;

import ds.linkedlist.LinkedList;
import ds.linkedlist.LinkedList.Node;

public class LinkedStack {
	private LinkedList list;
	private int top;
	private boolean error;
	private String errorDescription;

	public LinkedStack() {
		list = new LinkedList();
		top = -1;
	}

	public void push(int data) {
		top++;
		list.append(data);
	}

	public int pop() {
		if (top != -1) {
			Node currentNode = list.moveToEndNode(list.getHead());
			list.deleteAtPosition(top);
			top--;
			return currentNode.getData();
		} else {
			error = true;
			errorDescription = "Stack is empty. Unable to pop.";
			return -1;
		}
	}

	public boolean isError() {
		return error;
	}

	public void print() {
		list.printList();
	}

	public void printError() {
		System.out.println(errorDescription);
	}
}
