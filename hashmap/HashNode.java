package ds.hashmap;

public class HashNode {
	private int data;
	private String key;
	private int hashCode;
	private HashNode next;

	public HashNode(int data, String key, int hashCode) {
		super();
		this.data = data;
		this.key = key;
		this.hashCode = hashCode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public HashNode getNext() {
		return next;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}
}
