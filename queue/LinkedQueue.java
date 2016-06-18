package ds.queue;

import ds.linkedlist.LinkedList.Node;

public class LinkedQueue {
	Node front;
	Node rear;

	public LinkedQueue() {
		front = null;
		rear = null;
	}

	public boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		}
		return false;
	}

	public void enqueue(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			rear = newNode;
			front = rear;
		} else {
			rear.setNext(newNode);
			rear = rear.getNext();
		}
	}

	public int dequeue() {
		int data = -1;
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
