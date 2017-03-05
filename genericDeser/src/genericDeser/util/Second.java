/**
 * 
 */
package genericDeser.util;

/**
 * @author Omkar
 *
 */
public class Second {

	private int intValue;
	private double doubleValue;
	private boolean booleanValue;

	/**
	 * Default constructor.
	 */
	public Second() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Parametrized constructor.
	 * 
	 * @param myIntIn - value passed to the constructor to be set to private data member
	 * @param myDoubleIn - value passed to the constructor to be set to private data member
	 * @param myBooleanIn - value passed to the constructor to be set to private data member
	 */
	public Second(int myIntIn, double myDoubleIn, boolean myBooleanIn) {
		Logger.writeMessage("Parametric Constructor invoked: " + this.getClass().getName(),
				Logger.DebugLevel.CONSTRUCTOR);
		intValue = myIntIn;
		doubleValue = myDoubleIn;
		booleanValue = myBooleanIn;
	}

	/**
	 * Override hashCode with prime value set to 31.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booleanValue ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(doubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + intValue;
		return result;
	}

	/**
	 * Override the equals method to compare the object.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Second other = (Second) obj;
		if (booleanValue != other.booleanValue)
			return false;
		if (Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(other.doubleValue))
			return false;
		if (intValue != other.intValue)
			return false;
		return true;
	}

	/**
	 * 
	 * @return private value intValue.
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * sets private value intValue.
	 * 
	 * @param intValueIn - value passed to the constructor to be set to private data member
	 */
	public void setIntValue(int intValueIn) {
		this.intValue = intValueIn;
	}

	/**
	 * 
	 * @return private value doubleValue
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * sets private value doubleValue
	 * 
	 * @param doubleValueIn - value passed to the constructor to be set to private data member
	 */
	public void setDoubleValue(double doubleValueIn) {
		this.doubleValue = doubleValueIn;
	}

	/**
	 * 
	 * @return private booleanValue
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * sets private booleanValue
	 * 
	 * @param booleanValueIn - value passed to the constructor to be set to private data member
	 */
	public void setBooleanValue(boolean booleanValueIn) {
		this.booleanValue = booleanValueIn;
	}

	/**
	 * overrides the toString method to print the private data memebers.
	 */
	@Override
	public String toString() {
		return "Second [intValue=" + intValue + ", doubleValue=" + doubleValue + ", booleanValue=" + booleanValue + "]";
	}

}
