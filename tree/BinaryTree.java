package ds.tree;

public class BinaryTree {
	BinaryTreeNode root;

	public void insertDummy() {
		BinaryTreeNode newNode50 = new BinaryTreeNode(50);
		root = newNode50;

		BinaryTreeNode newNode40 = new BinaryTreeNode(40);
		root.setLeft(newNode40);

		BinaryTreeNode newNode60 = new BinaryTreeNode(60);
		root.setRight(newNode60);

		BinaryTreeNode newNode100 = new BinaryTreeNode(100);
		newNode60.setRight(newNode100);

		BinaryTreeNode newNode20 = new BinaryTreeNode(20);
		newNode40.setLeft(newNode20);
	}

	public void print(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			print(node.getLeft());
			print(node.getRight());
		}
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public boolean isBinarySearchTree(BinaryTreeNode node) {
		if (root == null) {
			return false;
		}
		if(node != null) {
		if (isSubTreeLesser(node.getLeft(), node.getData()) && isSubTreeGreater(node.getRight(), node.getData())
				&& isBinarySearchTree(node.getLeft()) && isBinarySearchTree(node.getRight())) {
			return true;
		} else {
			return false;
		}
		} else {
			return true; 
		}
	}

	public boolean isSubTreeLesser(BinaryTreeNode node, int data) {
		if (node == null) {
			return true;
		}

		if (node.getData() <= data && isSubTreeLesser(node.getLeft(), node.getData())
				&& isSubTreeLesser(node.getRight(), node.getData())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSubTreeGreater(BinaryTreeNode node, int data) {
		if (node == null) {
			return true;
		}
		if (node.getData() > data && isSubTreeGreater(node.getLeft(), node.getData())
				&& isSubTreeGreater(node.getRight(), node.getData())) {
			return true;
		} else {
			return false;
		}
	}
}
