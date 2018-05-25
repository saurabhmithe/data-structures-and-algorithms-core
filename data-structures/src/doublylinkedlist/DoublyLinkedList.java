package doublylinkedlist;

public class DoublyLinkedList {

	public class Node {
		int data;
		Node previous;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private boolean isError;

	public int getSize() {
		int size = 0;
		Node currentNode = head;

		while (currentNode != null) {
			size += 1;
			currentNode = currentNode.next;
		}

		return size;
	}

	public void insert(int data, int position) {
		if (position > 0 && position <= getSize()) {
			Node currentNode = head;

			// Traverse to desired position
			for (int i = 0; i < position - 1; i++) {
				currentNode = currentNode.next;
			}

			Node newNode = new Node(data);

			// If list empty or insert at 0th position
			if (position == 0) {
				newNode.next = head;
				newNode.next.previous = newNode;
				head = newNode;
			} else {
				Node nextNode = currentNode.next;
				currentNode.next = newNode;
				newNode.previous = currentNode;
				newNode.next = nextNode;
			}
		} else {
			System.out.println("Unable to insert item. Invalid position.");
			setError();
		}
	}

	public void append(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			// List is empty
			head = newNode;
			return;
		}
		Node currentNode = head;
		currentNode = moveToEndNode(currentNode);

		currentNode.next = newNode;
		newNode.previous = currentNode;
	}

	public Node moveToEndNode(Node startingNode) {
		while (startingNode.next != null) {
			startingNode = startingNode.next;
		}
		return startingNode;
	}

	public void printForward() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public void printBackward() {
		Node currentNode = head;
		currentNode = moveToEndNode(currentNode);

		while (currentNode != head.previous) {
			System.out.println(currentNode.data);
			currentNode = currentNode.previous;
		}
	}

	public boolean isError() {
		return isError;
	}

	public void setError() {
		isError = true;
	}
}
