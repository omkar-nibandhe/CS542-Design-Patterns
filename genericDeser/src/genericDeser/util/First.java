/**
 * 
 */
package genericDeser.util;

/**
 * @author Omkar
 *
 */
public class First {

	private int intValue;
	private float floatValue;
	private short shortValue;
	private String StringValue;

	/**
	 * Default Constructor
	 */
	public First() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Parametrised constructor.
	 * 
	 * @param myIntIn int value
	 * @param myFloatIn float value
	 * @param myShortIn short value
	 * @param myStringIn string value
	 */
	public First(int myIntIn, float myFloatIn, short myShortIn, String myStringIn) {
		Logger.writeMessage("Parametric Constructor invoked: " + this.getClass().getName(),
				Logger.DebugLevel.CONSTRUCTOR);
		intValue = myIntIn;
		floatValue = myFloatIn;
		shortValue = myShortIn;
		StringValue = myStringIn;
	}

	/**
	 * override the hashCode method by prime number value = 31
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(floatValue);
		result = prime * result + intValue;
		result = prime * result + shortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}

	/**
	 * Override the equals method
	 * 
	 * @param obj object to compare
	 * @return boolean true if equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(floatValue) != Float.floatToIntBits(other.floatValue))
			return false;
		if (intValue != other.intValue)
			return false;
		if (shortValue != other.shortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}

	/**
	 * getter method for private data member intValue
	 * 
	 * @return intValue - return private data member value
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * setter method for private data member intValue
	 * @param intValueIn - sets value to private data member
	 */
	public void setIntValue(int intValueIn) {
		this.intValue = intValueIn;
	}

	/**
	 * getter method for private data member floatValue
	 * 
	 * @return floatValue - return private data member value
	 */
	public float getFloatValue() {
		return floatValue;
	}

	/**
	 * setter method for private data member floatValue
	 * @param floatValueIn - sets private data member value
	 */
	public void setFloatValue(float floatValueIn) {
		this.floatValue = floatValueIn;
	}

	/**
	 * getter method for private data member shortValue
	 * 
	 * @return shortValue - return private data member value
	 */
	public short getShortValue() {
		return shortValue;
	}

	/**
	 * setter method for private data member shortValue
	 * @param shortValueIn - sets private data member value
	 */
	public void setShortValue(short shortValueIn) {
		this.shortValue = shortValueIn;
	}

	/**
	 * getter method for private data member StringValue
	 * 
	 * @return StringValue - return private data member value
	 */
	public String getStringValue() {
		return StringValue;
	}

	/**
	 * setter method for private data member StringValue
	 * @param stringValueIn - sets string value to private data member
	 */
	public void setStringValue(String stringValueIn) {
		StringValue = stringValueIn;
	}
	/**
	*Overrides the default toString method
	*
	*/
	@Override
	public String toString() {
		return "First [intValue=" + intValue + ", floatValue=" + floatValue + ", shortValue=" + shortValue
				+ ", StringValue=" + StringValue + "]";
	}

}
