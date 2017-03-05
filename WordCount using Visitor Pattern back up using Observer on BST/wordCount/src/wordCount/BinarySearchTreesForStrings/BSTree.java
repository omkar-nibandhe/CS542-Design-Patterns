package wordCount.BinarySearchTreesForStrings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import wordCount.visitors.TreeProcessingVisitorI;

public class BSTree implements TreeInterface {
	private NodeInterface rootNode = null;

	/**
	 * @param value
	 */
	@Override
	public void insert(String value) {
		NodeInterface newNode = new BSTNode(value);

		if (rootNode == null) {
			rootNode = newNode;
			return;
		}
		NodeInterface currentNode = rootNode;
		int result;
		while (true) {
			result = currentNode.getWord().compareTo(newNode.getWord());
			if (result > 0) {
				if (null == currentNode.getLeftChild()) {
					currentNode.setLeftChild(newNode);
					break;
				} else {
					currentNode = currentNode.getLeftChild();
				}
			} else if (result < 0) {
				if (null == currentNode.getRightChild()) {
					currentNode.setRightChild(newNode);
					break;
				} else {
					currentNode = currentNode.getRightChild();
				}
			} else {
				currentNode.setNoOccurences(currentNode.getNoOccurences() + 1);
				break;
			}
		}
	}

	/**
	 * @param node
	 */
	@Override
	public void insert(NodeInterface node) {
		NodeInterface newNode = node;

		if (rootNode == null) {
			rootNode = newNode;
			return;
		}
		NodeInterface currentNode = rootNode;
		int result;
		while (true) {
			result = currentNode.getWord().compareTo(newNode.getWord());
			if (result > 0) {
				if (null == currentNode.getLeftChild()) {
					currentNode.setLeftChild(newNode);
					break;
				} else {
					currentNode = currentNode.getLeftChild();
				}
			} else if (result < 0) {
				if (null == currentNode.getRightChild()) {
					currentNode.setRightChild(newNode);
					break;
				} else {
					currentNode = currentNode.getRightChild();
				}
			} else {
				currentNode.setNoOccurences(currentNode.getNoOccurences() + 1);
				break;
			}
		}
	}

	@Override
	/**
	 * @param searchString
	 * @return NodeInterface
	 */
	public NodeInterface search(String searchString) {
		if (rootNode == null) {
			return null;
		}
		NodeInterface currentNode = rootNode;
		while (null != currentNode) {
			int result = currentNode.getWord().compareTo(searchString);
			if (result > 0) {
				currentNode = currentNode.getLeftChild();
			} else if (result < 0) {
				currentNode = currentNode.getRightChild();
			} else {
				return currentNode;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void printInorder() {
		if (rootNode == null) {
			return;
		}
		Stack<BSTNode> s = new Stack<BSTNode>();
		NodeInterface currentNode = rootNode;
		while (!s.empty() || currentNode != null) {
			if (currentNode != null) {
				s.push((BSTNode) currentNode);
				currentNode = currentNode.getLeftChild();
			} else {
				NodeInterface n = s.pop();
				System.out.println(n.getWord() + " " + n.getNoOccurences());
				currentNode = n.getRightChild();
			}
		}
	}

	/**
	 * @param visitor
	 */
	@Override
	public void accept(TreeProcessingVisitorI visitor) {
		visitor.visit(this);
	}

	/**
	 * @return NodeInterface
	 */
	@Override
	public NodeInterface getRootNode() {
		return rootNode;
	}

	@Override
	public String toString() {
		return "BSTree [rootNode=" + rootNode + "]";
	}

	/**
	 * @param fileName
	 */
	@Override
	public void printInorderToFile(String filename) {
		if (rootNode == null) {
			return;
		}
		BufferedWriter fileWriter = null;
		try {

			fileWriter = new BufferedWriter(new FileWriter(new File(filename)));
			Stack<BSTNode> s = new Stack<BSTNode>();
			NodeInterface currentNode = rootNode;
			while (!s.empty() || currentNode != null) {
				if (currentNode != null) {
					s.push((BSTNode) currentNode);
					currentNode = currentNode.getLeftChild();
				} else {
					NodeInterface n = s.pop();
					fileWriter.write(n.getWord() + " " + n.getNoOccurences()+"\n");
					currentNode = n.getRightChild();
				}
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exiting");
			System.exit(1);

		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		// TODO Auto-generated method stub

	}
}
