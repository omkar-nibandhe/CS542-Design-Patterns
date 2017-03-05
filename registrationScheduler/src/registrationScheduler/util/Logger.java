
package registrationScheduler.util;

import registrationScheduler.store.Results;

public class Logger {

	/*
	 * Constructor init the private variables
	 * 
	 */
	public Logger() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	public static enum DebugLevel {
		CONSTRUCTOR, THREAD, RESULT, DATA_STRUCTURE, OUTPUT
	};

	private static DebugLevel debugLevel;

	/**
	 * 
	 * @param levelIn
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 3:
			debugLevel = DebugLevel.THREAD;
			break;
		case 2:
			debugLevel = DebugLevel.RESULT;
			break;
		case 1:
			debugLevel = DebugLevel.DATA_STRUCTURE;
			break;
		case 0:
			debugLevel = DebugLevel.OUTPUT;
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

	// @return None
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public static void writeMsg(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.print(message);
	}

	public static DebugLevel getDebugLevel() {
		return debugLevel;
	}

	public static void writeOutput(Results resultIn) {
		// resultIn.writeSchedulesToScreen();
	}

	@Override
	public String toString() {
		return "Logger [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
