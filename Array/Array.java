/**
 * 
 * @author saurabhmithe
 * 
 * This is a simple implementation of arrays.
 * Insertion is done at the end.
 * Deletion from middle results in shifting of elements.
 * Search is linear.
 * 
 */

public class Array {
	private int[] array;
	private int numberOfElements;

	public Array(int size) {
		numberOfElements = 0;
		array = new int[size];
	}

	public void insert(int value) {
		array[numberOfElements] = value;
		numberOfElements++;
	}

	public boolean search(int searchKey) {
		int j;
		for (j = 0; j < numberOfElements; j++) {
			if (array[j] == searchKey) {
				return true;
			}
		}
		return false;
	}

	public boolean delete(int key) {
		int j;
		for (j = 0; j < numberOfElements; j++) {
			if (array[j] == key) {
				break;
			}
		}
		if (j != numberOfElements) {
			for (int k = j; k < numberOfElements; k++) {
				array[k] = array[k + 1];
			}
			numberOfElements--;
			return true;
		} else {
			return false;
		}
	}

	public void printArray() {
		if (numberOfElements > 0) {
			for (int i = 0; i < numberOfElements; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("");
		} else {
			System.out.println("No elements in array.");
		}
	}
}
