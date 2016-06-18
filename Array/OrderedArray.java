/**
 * 
 * @author saurabhmithe
 *
 * Insertion is ordered and array is kept sorted.
 * Deletion from middle results in shifting of elements.
 * Search is binary.
 *
 */

public class OrderedArray {
	private int[] array;
	private int numberOfElements;

	// Constructor
	public OrderedArray(int size) {
		array = new int[size];
		numberOfElements = 0;
	}

	public int size() {
		return numberOfElements;
	}

	// Linear insert
	public void insert(int value) {
		int j;
		for (j = 0; j < numberOfElements; j++) {
			if (array[j] > value) {
				break;
			}
		}
		for (int k = numberOfElements; k > j; k--) {
			array[k] = array[k - 1];
		}
		array[j] = value;
		numberOfElements++;
	}

	// Binary search
	public int find(int searchKey) {
		int low = 0;
		int high = numberOfElements - 1;
		int currentIndex;

		while (true) {
			currentIndex = (low + high) / 2;
			if (array[currentIndex] == searchKey) {
				return currentIndex;
			} else if (low > high) {
				return numberOfElements;
			} else {
				if (array[currentIndex] < searchKey) {
					// Look in upper half
					low = currentIndex + 1;
				} else {
					// Look in lower half
					high = currentIndex - 1;
				}
			}
		}
	}

	// Delete
	public boolean delete(int key) {
		int index = find(key);
		if (index != numberOfElements) {
			for (int k = index; k < numberOfElements; k++) {
				array[k] = array[k + 1];
			}
			numberOfElements--;
			return true;
		} else {
			return false;
		}
	}

	// Display all contents of array
	public void printArray() {
		if (numberOfElements > 0) {
			for (int i = 0; i < numberOfElements; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println("");
		} else {
			System.out.println("Please set number of elements");
		}
	}
}
