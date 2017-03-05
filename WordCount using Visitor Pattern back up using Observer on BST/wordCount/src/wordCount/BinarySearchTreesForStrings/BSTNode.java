/**
 * 
 */
package wordCount.wordCount.src.wordCount.BinarySearchTreesForStrings;

import java.util.List;

import wordCount.util.ObserverInterface;
import wordCount.util.SubjectInterface;

/**
 * 
 * @author Omkar Nibandhe Mar 5, 2017 https://www.linkedin.com/in/omkarnibandhe
 */
public class BSTNode implements NodeInterface, SubjectInterface, ObserverInterface {

	private String word;
	private NodeInterface leftChild;
	private NodeInterface rightChild;
	private int noCharacters;
	private int noOccurences;
	private List<ObserverInterface> observerList;
	private SubjectInterface subject;

	/**
	 * 
	 * @param wordIn
	 */
	public BSTNode(String wordIn) {
		word = wordIn.trim();
		noCharacters = word.length();
		noOccurences = 1;
		observerList = new ArrayList<ObserverInterface>();
		// this.subject = subjectIn;
		// subject.registerObserver(this);

	}

	/**
	 * 
	 * @param subjectIn
	 */
	public void setSubject(SubjectInterface subjectIn) {
		this.subject = subjectIn;
		subject.registerObserver(this);
	}

	/**
	 * @return String
	 */
	public String getWord() {
		return word;
	}

	/**
	 * 
	 * @param value
	 */
	public void setWord(String value) {
		this.word = value;
	}

	/**
	 * 
	 */
	public NodeInterface getLeftChild() {
		return leftChild;
	}

	/**
	 * 
	 */
	public void setLeftChild(NodeInterface leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return NodeInterface
	 */
	public NodeInterface getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild
	 */
	public void setRightChild(NodeInterface rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * @return int
	 */
	public int getNoCharacters() {
		return noCharacters;
	}

	/**
	 * 
	 * @param noCharactersIn
	 */
	public void setNoCharacters(int noCharactersIn) {
		this.noCharacters = noCharactersIn;
	}

	/**
	 * @return int
	 */
	public int getNoOccurences() {
		return noOccurences;
	}

	/**
	 * @param noOccurences
	 */
	public void setNoOccurences(int noOccurences) {
		this.noOccurences = noOccurences;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Node [value=" + word + ", leftChild=" + leftChild + ", rightChild=" + rightChild + ", noCharacters="
				+ noCharacters + ", noOccurences=" + noOccurences + "]";
	}

	/**
	 * @param noOccurrancesIn
	 *            : int
	 */
	@Override
	public void update(int noOccurancesIn) {
		// TODO Auto-generated method stub
		this.setNoOccurences(this.getNoOccurences() + noOccurancesIn);

	}

	/**
	 * @param node
	 *            : ObserverInterface
	 */
	@Override
	public void registerObserver(ObserverInterface node) {
		// TODO Auto-generated method stub
		observerList.add(node);

	}

	/**
	 * @param node
	 *            : ObserverInterface
	 */
	@Override
	public void removeObserver(ObserverInterface node) {
		// TODO Auto-generated method stub
		int i = observerList.indexOf(node);
		if (i >= 0) {
			observerList.remove(i);
		}
	}

	/**
	 * 
	 */
	@Override
	public void notifyObserver(int value) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observerList.size(); i++) {
			ObserverInterface observer = (ObserverInterface) observerList.get(i);
			observer.update(value);

		}
	}
}
