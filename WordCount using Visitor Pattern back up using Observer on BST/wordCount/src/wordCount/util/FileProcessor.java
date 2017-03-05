package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

	private BufferedReader fileReader = null;
	private BufferedWriter fileWriter = null;

	/**
	 * 
	 * @param fileReaderIn
	 * @param fileWriterIn
	 */
	public FileProcessor(String fileReaderIn, String fileWriterIn) {
		try {
			fileReader = new BufferedReader(new FileReader(fileReaderIn));
			fileWriter = new BufferedWriter(new FileWriter(new File(fileWriterIn)));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exiting");
			System.exit(1);

		} finally {
		}

	}

	/**
	 * 
	 * @return void
	 */
	public String readFromFile() {
		try {
			return fileReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	/**
	 * 
	 * @param outputString
	 */
	public void writeToFile(String outputString) {
		try {
			fileWriter.write(outputString);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(outputString);
		}
	}
}
