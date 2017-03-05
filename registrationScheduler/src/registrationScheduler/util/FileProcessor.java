package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class FileProcessor {
	public volatile Vector<Vector<String>> multi;
	private String InputFileName = null;
	private String OutputFileName = null;
	private Integer numThread = 0;
	public BufferedReader reader = null;

	/**
	 * 
	 * @param args
	 */
	public FileProcessor(String[] args) {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		this.multi = new Vector<Vector<String>>();
		this.InputFileName = args[0];
		this.setOutputFileName(args[1]);
		this.setNumThread(Integer.parseInt(args[2]));
		Logger.setDebugValue(Integer.parseInt(args[3]));
		try {
			reader = new BufferedReader(new FileReader(InputFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
	}

	public synchronized String getLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	public String getOutputFileName() {
		return OutputFileName;
	}

	/**
	 * 
	 * @param outputFileName
	 */
	public void setOutputFileName(String outputFileName) {
		OutputFileName = outputFileName;
	}

	public Integer getNumThread() {
		return numThread;
	}

	/**
	 * 
	 * @param numThread
	 */
	public void setNumThread(Integer numThread) {
		this.numThread = numThread;
	}
}
