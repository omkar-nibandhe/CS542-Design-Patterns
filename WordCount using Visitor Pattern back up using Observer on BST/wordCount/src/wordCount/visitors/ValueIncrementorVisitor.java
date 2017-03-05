/**
 * 
 */
package wordCount.visitors;

import java.util.Stack;

import wordCount.BinarySearchTreesForStrings.BSTNode;
import wordCount.BinarySearchTreesForStrings.NodeInterface;
import wordCount.BinarySearchTreesForStrings.TreeInterface;

/**
 * 
 * @author Omkar Nibandhe Mar 5, 2017 https://www.linkedin.com/in/omkarnibandhe
 */
public class ValueIncrementorVisitor implements TreeProcessingVisitorI {

	private int value;

	public ValueIncrementorVisitor(int valueIn) {
		// TODO Auto-generated constructor stub
		value = valueIn;
	}

	/**
	 * @param BSTree
	 */
	@Override
	public void visit(TreeInterface BSTree) {
		// TODO Auto-generated method stub
		makeInOrderVisit(BSTree);
	}

	/**
	 * 
	 * @param BSTree
	 */
	private void makeInOrderVisit(TreeInterface BSTree) {
		// TODO Auto-generated method stub
		NodeInterface rootNode = BSTree.getRootNode();
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
				if (!n.getWord().isEmpty()) {
					addValuelogic(n);
				}
				currentNode = n.getRightChild();
			}
		}

	}

	/**
	 * 
	 * @param n
	 */
	private void addValuelogic(NodeInterface n) {
		// TODO Auto-generated method stub
		BSTNode temp = (BSTNode) n;
		temp.setNoOccurences(n.getNoOccurences() + value);
		temp.notifyObserver(value);
	}

}
