/**
 * 
 */
package wordCount.util;

/**
 * @author Omkar
 *
 */

public class Logger {

	/*
	 * Constructor init the private variables
	 * 
	 */
	public Logger() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	public static enum DebugLevel {
		CONSTRUCTOR,
	};

	private static DebugLevel debugLevel;

	/**
	 * 
	 * @param levelIn
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;

		default:
			break;
		}
	}

	/**
	 * 
	 * @param levelIn
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * 
	 * @param message
	 * @param levelIn
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * 
	 * @return
	 */
	public static DebugLevel getDebugLevel() {
		return debugLevel;
	}

	@Override
	public String toString() {
		return "Logger [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
