/**
 * 
 */
package genericDeser.util;

/**
 * @author Omkar
 *
 */

public class Logger {
	/**
	 * 
	 */
	public Logger() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * 
	 * @author Omkar
	 *
	 */
	public static enum DebugLevel {
		OUTPUT, CONSTRUCTOR, RESULT
	};

	/**
	 * debugLevel specifies the debug level for the application run. This is set
	 * by through command line arguments.
	 */
	private static DebugLevel debugLevel;

	/**
	 * 
	 *@param levelIn - check the debugger value
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.OUTPUT;
			break;
		case 1:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 2:
			debugLevel = DebugLevel.RESULT;
			break;
		default:
			System.err.println("Unexpected debug level.");
			System.exit(1);
			break;
		}
	}

	/**
	 * sets debugLevel.
	 * 
	 * @param levelIn - set debuglevel
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * Logger writes the message to standard output.
	 * 
	 * @param message - write the message based on the debug value passed.
	 * @param levelIn - passed debug value.
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * Logger writes message to standard error.
	 * 
	 * @param message - write the message based on the debug value passed.
	 * @param levelIn - passed debug value.
	 */
	public static void writeErrorMsg(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.err.print(message);
	}

	/**
	 * 
	 * @return debugLevel - value
	 */
	public static DebugLevel getDebugLevel() {
		return debugLevel;
	}

	/**
	 * Override the default toString method to print the class name, hashCode.
	 */
	@Override
	public String toString() {
		return "Logger [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
