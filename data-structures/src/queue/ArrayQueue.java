package queue;

public class ArrayQueue {

	private int[] array;
	private int front;
	private int rear;

	private boolean error;
	private String errorDescription;

	public ArrayQueue(int size) {
		array = new int[size];
		front = -1;
		rear = -1;
	}

	public void enqueue(int data) {
		if (isEmpty()) {
			front = 0;
			rear = 0;
			array[rear] = data;
		} else if (isFull()) {
			error = true;
			errorDescription = "Quque is full. Enqueue failed.";
		} else {
			rear = (rear + 1) % array.length;
			array[rear] = data;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			error = true;
			errorDescription = "Queue is empty. Dequeue failed.";
			return -1;
		} else if (front == rear) {
			int data = array[front];
			front = -1;
			rear = -1;
			return data;
		} else {
			int data = array[front];
			front = (front + 1) % array.length;
			return data;
		}
	}

	public int peek() {
		return array[front];
	}

	public void print() {
		if (isEmpty()) {
			error = true;
			errorDescription = "Queue is empty";
		} else {
			System.out.println("In order from latest to oldest");
			int i = front;
			while (i < array.length) {
				System.out.print(array[i] + " ");
				i++;
			}
			i = i % array.length;
			if(array[i] != 0) {
				while(i < front) {
					System.out.print(array[i] + " ");
					i++;
				}
			}
		}
	}

	public boolean isFull() {
		return (rear + 1) % array.length == front;
	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	public boolean isError() {
		return error;
	}

	public void printError() {
		System.out.println(errorDescription);
	}
}