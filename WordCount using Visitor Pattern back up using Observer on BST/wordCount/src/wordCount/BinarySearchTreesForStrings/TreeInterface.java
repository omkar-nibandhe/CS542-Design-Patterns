/**
 * 
 */
package wordCount.BinarySearchTreesForStrings;

import wordCount.visitors.TreeProcessingVisitorI;

/**
 * @author Omkar
 *
 */
public interface TreeInterface {
	/**
	 * 
	 * @param value
	 */
	public void insert(String value);

	/**
	 * 
	 * @param searchString
	 * @return NodeInterface
	 */
	public NodeInterface search(String searchString);

	/**
	 * 
	 */
	public void printInorder();

	/**
	 * 
	 * @return NodeInterface
	 */
	public NodeInterface getRootNode();

	/**
	 * 
	 * @param visitor
	 */
	public void accept(TreeProcessingVisitorI visitor);

	void insert(NodeInterface node);

	public void printInorderToFile(String string);

	
}
