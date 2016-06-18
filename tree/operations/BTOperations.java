package ds.tree.operations;

import ds.tree.BinaryTree;

public class BTOperations {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertDummy();
		
		if(tree.isBinarySearchTree(tree.getRoot())){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
