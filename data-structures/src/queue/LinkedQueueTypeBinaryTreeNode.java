package queue;

import ds.linkedlist.LinkedListTypeBinaryTreeNode.Node;
import ds.tree.BinaryTreeNode;

public class LinkedQueueTypeBinaryTreeNode {
	Node front;
	Node rear;

	public LinkedQueueTypeBinaryTreeNode() {
		front = null;
		rear = null;
	}

	public boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		}
		return false;
	}

	public void enqueue(BinaryTreeNode data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			rear = newNode;
			front = rear;
		} else {
			rear.setNext(newNode);
			rear = rear.getNext();
		}
	}

	public BinaryTreeNode dequeue() {
		BinaryTreeNode data = null;
		if (!isEmpty()) {
			if (front == rear) {
				data = front.getData();
				front = null;
				rear = null;
			} else {
				data = front.getData();
				front = front.getNext();
			}
		}
		return data;
	}

	public void print() {
		if (!isEmpty()) {
			Node currentNode = front;
			while (currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
		} else {
			System.out.println("Queue is empty");
		}
	}
}
