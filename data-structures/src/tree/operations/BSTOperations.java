package tree.operations;

import tree.BinarySearchTree;

public class BSTOperations {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50, tree.getRoot());
		
		tree.insert(40, tree.getRoot());
		tree.insert(35, tree.getRoot());
		tree.insert(45, tree.getRoot());
		tree.insert(30, tree.getRoot());
		tree.insert(37, tree.getRoot());
		tree.insert(42, tree.getRoot());
		tree.insert(48, tree.getRoot());
		
		tree.insert(60, tree.getRoot());
		tree.insert(55, tree.getRoot());
		tree.insert(65, tree.getRoot());
		tree.insert(52, tree.getRoot());
		tree.insert(57, tree.getRoot());
		tree.insert(63, tree.getRoot());
		tree.insert(68, tree.getRoot());
		/*
		tree.delete(69, tree.getRoot(), tree.getRoot());
		
		tree.print(tree.getRoot());
		
		System.out.println("Min: " + tree.getMin(tree.getRoot()));
		System.out.println("Max: " + tree.getMax(tree.getRoot()));

		System.out.println("Height: " + tree.getHeight(tree.getRoot()));

		System.out.println("LevelOrder: ");
		tree.printLevelOrder(tree.getRoot());

		System.out.println("PreOrder: ");
		tree.printPreOrder(tree.getRoot());

		System.out.println("InOrder: ");
		tree.printInOrder(tree.getRoot());

		System.out.println("PostOrder: ");
		tree.printPostOrder(tree.getRoot());*/
		
		System.out.println(tree.getInorderSuccessor(tree.getRoot(), 63));
	}

}
