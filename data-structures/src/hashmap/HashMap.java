package hashmap;

public class HashMap {
	HashNodeHeader[] bucketArray;
	int bucketSize;

	public HashMap(int bucketSize) {
		this.bucketSize = bucketSize;
		bucketArray = new HashNodeHeader[bucketSize];

		initializeBucketArray();
	}

	private void initializeBucketArray() {
		for (int i = 0; i < bucketSize; i++) {
			bucketArray[i] = new HashNodeHeader();
		}
	}

	private int getHashIndex(String key) {
		int hashCode = key.hashCode();
		int index = hashCode % bucketSize;
		return index;
	}

	public void put(String key, int value) {
		int index = getHashIndex(key);

		HashNode newNode = new HashNode(value, key, key.hashCode());

		if (bucketArray[index].getHashNode() == null) {
			bucketArray[index].setHashNode(newNode);
		} else {
			HashNode currentNode = bucketArray[index].getHashNode();
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
	}

	public boolean search(String key) {
		int index = getHashIndex(key);

		if (bucketArray[index].getHashNode() != null) {
			HashNode currentNode = bucketArray[index].getHashNode();
			while (currentNode.getKey() != key) {
				if (currentNode.getNext() == null) {
					return false;
				} else {
					currentNode = currentNode.getNext();
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(String key) {
		int index = getHashIndex(key);
		if (bucketArray[index].getHashNode() != null) {
			if (bucketArray[index].getHashNode().getKey().equals(key)) {
				bucketArray[index].setHashNode(bucketArray[index].getHashNode().getNext());
				return true;
			} else {
				HashNode currentNode = bucketArray[index].getHashNode();
				HashNode previousNode = null;
				while (currentNode != null && currentNode.getKey() != key) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				if (currentNode != null) {
					previousNode.setNext(currentNode.getNext());
					return true;
				} else {
					previousNode.setNext(null);
					return false;
				}
			}
		}
		return false;
	}

	public void printHashMap() {
		for (int i = 0; i < bucketSize; i++) {
			if (bucketArray[i].getHashNode() != null) {
				HashNode currentNode = bucketArray[i].getHashNode();
				while (currentNode != null) {
					System.out.println(currentNode.getKey() + " " + currentNode.getData());
					currentNode = currentNode.getNext();
				}
			}
		}
	}
}
