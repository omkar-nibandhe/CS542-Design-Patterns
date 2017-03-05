/**
 * 
 */
package genericDeser.fileOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import genericDeser.util.Logger;

/**
 * @author Omkar
 *
 */
public class FileProcessor {
	public BufferedReader reader = null;
	private String InputFileName = null;

	/**
	 * default Constructor
	 */
	public FileProcessor() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Parameterised Constructor to set input File Name
	 * 
	 * @param inputFileNameIn file name
	 */
	public FileProcessor(String inputFileNameIn) {
		Logger.writeMessage("Parametric Constructor invoked: " + this.getClass().getName(),
				Logger.DebugLevel.CONSTRUCTOR);

		this.InputFileName = inputFileNameIn;

		try {
			reader = new BufferedReader(new FileReader(InputFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			// DO Nothing
		}
	}

	/**
	 * method to read a line from input file
	 * 
	 * @return new line from input file.
	 */
	public String getLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Override the toString method to print the data members.
	 */
	@Override
	public String toString() {
		return "FileProcessor [reader=" + reader + ", InputFileName=" + InputFileName + "]";
	}

}
