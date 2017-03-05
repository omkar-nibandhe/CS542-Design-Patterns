/**
 * 
 */
package wordCount.visitors;

import java.util.Stack;

import wordCount.BinarySearchTreesForStrings.BSTNode;
import wordCount.BinarySearchTreesForStrings.NodeInterface;
import wordCount.BinarySearchTreesForStrings.TreeInterface;

/**
 * @author Omkar
 *
 */
public class CloneAndObserveVisitor implements TreeProcessingVisitorI {
	private TreeInterface BSTreeBackup = null;

	@Override
	public String toString() {
		return "CloneAndObserveVisitor [BSTreeBackup=" + BSTreeBackup + "]";
	}

	/**
	 * @param BSTree
	 *            : TreeInterface
	 */
	@Override
	public void visit(TreeInterface BSTree) {

		makeInOrderVisit(BSTree);
	}

	/**
	 * 
	 * @param BSTreeBackupIn
	 */
	public CloneAndObserveVisitor(TreeInterface BSTreeBackupIn) {
		BSTreeBackup = BSTreeBackupIn;
	}

	/**
	 * 
	 * @param BSTree
	 */
	private void makeInOrderVisit(TreeInterface BSTree) {
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
					cloneAndSetObserver(n);
				}
				currentNode = n.getRightChild();
			}
		}
	}

	/**
	 * 
	 * @param n
	 */
	private void cloneAndSetObserver(NodeInterface n) {
		// TODO Auto-generated method stub

		BSTNode temp = (BSTNode) n;
		BSTNode clonedTemp = new BSTNode(temp.getWord());
		clonedTemp.setNoCharacters(temp.getNoCharacters());
		clonedTemp.setNoOccurences(temp.getNoOccurences());

		// clonedTemp.setSubject((BSTNode) n);

		temp.registerObserver(clonedTemp);
		BSTreeBackup.insert(clonedTemp);
		// tempClone = (BSTNode) temp.clone();// = (BSTNode)temp;
		// temp.registerObserver(temp);

	}
}
