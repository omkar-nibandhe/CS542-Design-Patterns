/**
 * 
 */
package wordCount.util;

/**
 * @author Omkar
 *
 */
public interface SubjectInterface {
	/**
	 * 
	 * @param node
	 */
	public void registerObserver(ObserverInterface node);

	/**
	 * 
	 * @param node
	 */
	public void removeObserver(ObserverInterface node);

	/**
	 * 
	 * @param value
	 */
	public void notifyObserver(int value);
}
