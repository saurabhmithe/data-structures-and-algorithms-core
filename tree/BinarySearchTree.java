package ds.tree;

import ds.queue.LinkedQueueTypeBinaryTreeNode;

public class BinarySearchTree {
	private BinaryTreeNode root;

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void insert(int data, BinaryTreeNode parent) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);

		if (parent == null) {
			// tree is empty
			root = newNode;
			return;
		}
		if (data <= parent.getData()) {
			if (parent.getLeft() == null) {
				parent.setLeft(newNode);
			} else {
				insert(data, parent.getLeft());
			}
		}
		if (data > parent.getData()) {
			if (parent.getRight() == null) {
				parent.setRight(newNode);
			} else {
				insert(data, parent.getRight());
			}
		}
	}

	public int getMin(BinaryTreeNode node) {
		if (root == null) {
			return -1;
		}
		if (node.getLeft() == null) {
			return node.getData();
		} else {
			return getMin(node.getLeft());
		}
	}

	public int getMax(BinaryTreeNode node) {
		if (root == null) {
			return -1;
		}
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getMax(node.getRight());
		}
	}

	public int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return -1;
		} else {
			return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
		}
	}

	public void delete(int data, BinaryTreeNode parent, BinaryTreeNode mainParent) {
		if (root == null) {
			System.out.println("Tree Empty");
			return;
		}

		BinaryTreeNode nodeToBeDeleted = null;

		// Locate the node
		while (parent != null) {
			if (data == parent.getData()) {
				nodeToBeDeleted = parent;
				break;
			} else {
				if (data <= parent.getData()) {
					mainParent = parent;
					parent = parent.getLeft();
				} else {
					mainParent = parent;
					parent = parent.getRight();
				}
			}
		}

		// Delete the node
		if (nodeToBeDeleted != null) {

			// No children present
			if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
				if (mainParent.getData() > nodeToBeDeleted.getData()) {
					mainParent.setLeft(null);
				} else {
					mainParent.setRight(null);
				}
			}

			// Only left child present
			else if (nodeToBeDeleted.getLeft() != null && nodeToBeDeleted.getRight() == null) {
				if (mainParent.getData() > nodeToBeDeleted.getData()) {
					mainParent.setLeft(nodeToBeDeleted.getLeft());
				} else {
					mainParent.setRight(nodeToBeDeleted.getLeft());
				}
			}

			// Only right child present
			else if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() != null) {
				if (mainParent.getData() > nodeToBeDeleted.getData()) {
					mainParent.setLeft(nodeToBeDeleted.getRight());
				} else {
					mainParent.setRight(nodeToBeDeleted.getRight());
				}
			}

			// Both children present
			else {
				BinaryTreeNode tmp = nodeToBeDeleted;
				BinaryTreeNode tmpParent = tmp;
				tmp = tmp.getRight();

				boolean deleteRight = true;

				while (tmp.getLeft() != null) {
					deleteRight = false;
					tmpParent = tmp;
					tmp = tmp.getLeft();
				}

				nodeToBeDeleted.setData(tmp.getData());
				if (deleteRight) {
					tmpParent.setRight(null);
				} else {
					tmpParent.setLeft(null);
				}
			}
		} else {
			System.out.println("Delete unsuccessful. No such data present.");
		}
	}

	public boolean isEmpty() {
		return (root.getLeft() == null && root.getRight() == null);
	}

	public void print(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			print(node.getLeft());
			print(node.getRight());
		}
	}

	public boolean search(int data, BinaryTreeNode node) {
		if (node == null) {
			return false;
		} else if (node.getData() == data) {
			return true;
		} else if (data <= node.getData()) {
			return search(data, node.getLeft());
		} else {
			return search(data, node.getRight());
		}
	}

	public void printLevelOrder(BinaryTreeNode node) {
		LinkedQueueTypeBinaryTreeNode queue = new LinkedQueueTypeBinaryTreeNode();
		if (root == null) {
			System.out.println("Tree Empty.");
			return;
		} else {
			queue.enqueue(root);
		}

		while (!queue.isEmpty()) {
			BinaryTreeNode nd = queue.dequeue();
			System.out.println(nd.getData());

			if (nd.getLeft() != null) {
				queue.enqueue(nd.getLeft());
			}
			if (nd.getRight() != null) {
				queue.enqueue(nd.getRight());
			}
		}
	}

	public void printPreOrder(BinaryTreeNode node) {
		if (root == null) {
			return;
		}
		System.out.println(node.getData());
		if (node.getLeft() != null) {
			printPreOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			printPreOrder(node.getRight());
		}
	}

	public void printInOrder(BinaryTreeNode node) {
		if (root == null) {
			return;
		}
		if (node.getLeft() != null) {
			printInOrder(node.getLeft());
		}
		System.out.print(node.getData() + " ");
		if (node.getRight() != null) {
			printInOrder(node.getRight());
		}
	}

	public void printPostOrder(BinaryTreeNode node) {
		if (node.getLeft() != null) {
			printPostOrder(node.getLeft());
		}
		if (node.getRight() != null) {
			printPostOrder(node.getRight());
		}
		System.out.println(node.getData());
	}

	public int getInorderSuccessor(BinaryTreeNode rootNode, int data) {
		BinaryTreeNode node = find(rootNode, data);

		if (root == null) {
			// Tree is empty
			return -1;
		} else {

			if (node.getRight() != null) {
				// Right subtree is present
				BinaryTreeNode temp = node.getRight();
				while (temp.getLeft() != null) {
					temp = temp.getLeft();
				}
				return temp.getData();
			} else {
				// No right subtree is present
				BinaryTreeNode succesor = null;
				BinaryTreeNode ancestor = rootNode;

				while (node != ancestor) {
					if (node.getData() < ancestor.getData()) {
						succesor = ancestor;
						ancestor = ancestor.getLeft();
					} else {
						ancestor = ancestor.getRight();
					}
				}
				if (succesor != null) {
					return succesor.getData();
				} else {
					return -1;
				}
			}

		}
	}

	private BinaryTreeNode find(BinaryTreeNode root, int data) {
		if (root.getData() == data) {
			return root;
		} else {
			if (root.getData() > data) {
				return find(root.getLeft(), data);
			} else {
				return find(root.getRight(), data);
			}
		}
	}
}
