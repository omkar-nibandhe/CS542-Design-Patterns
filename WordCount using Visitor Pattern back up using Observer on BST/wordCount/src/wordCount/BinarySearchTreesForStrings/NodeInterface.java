/**
 * 
 */
package wordCount.BinarySearchTreesForStrings;

/**
 * @author Omkar
 *
 */
public interface NodeInterface{
	/**
	 * 
	 * @return NodeInterface
	 */
	public NodeInterface getRightChild();

	/**
	 * 
	 * @param newNode
	 */
	public void setRightChild(NodeInterface newNode);

	/**
	 * 
	 * @return NodeInterface
	 */
	public NodeInterface getLeftChild();

	/**
	 * 
	 * @param newNode
	 */
	public void setLeftChild(NodeInterface newNode);

	/**
	 * 
	 * @return int
	 */
	public int getNoOccurences();

	/**
	 * 
	 * @param i
	 *            : int
	 */
	public void setNoOccurences(int i);

	/**
	 * 
	 * @return
	 */
	public String getWord();

	/**
	 * 
	 * @return int
	 */
	public int getNoCharacters();
	// public void registerObserver(BSTNode bstNode);

}
