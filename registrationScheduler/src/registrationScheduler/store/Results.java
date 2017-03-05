
package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import registrationScheduler.util.Logger;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	// appropriate data structure as private data member

	private volatile Vector<String> nameList;
	private volatile Vector<Vector<Integer>> finalResults;

	/*
	 * calculates the averagePreferenceScore on the final data structure and
	 * returns a float value
	 */
	public synchronized float averagePreferenceScore() {
		int sum = 0;
		for (int i = 0; i < 80; i++) {
			if (this.finalResults.get(i).size() > 9) {
				sum = sum + this.finalResults.get(i).get(8);
			}
		}
		return ((float) sum / (float) 80);
	}

	/*
	 * gets the preference position from the data structure and converts the int
	 * to subject name if it has been allocated.
	 *
	 * @param i
	 * 
	 * @param j
	 * 
	 * @return
	 */
	public synchronized String commitFinalSubject(int i, int j) {
		if (this.finalResults.size() <= i) {
			return "";
		}
		if (j == 8) {
			return this.finalResults.get(i).get(j).toString();
		}
		if (this.finalResults.size() > i) {
			if (this.finalResults.get(i).size() > j) {
				if (this.finalResults.get(i).get(j) > 0) {
					return "";
				} else {
					int ASCIIcode = 64 + j;
					String courseName = new Character((char) ASCIIcode).toString();
					return courseName;
				}
			}
		}
		return "";
	}

	/*
	 * Override the Interface to print on screen when logger is set to
	 * data_structure level.
	 * 
	 */
	@Override
	public void writeScheduleToScreen() {
		// ..
		for (int i = 0; i < this.finalResults.size(); i++) {
			// System.out.print("\n" + nameList.get(i));
			Logger.writeMessage("\n Logger Invoked: " + this.nameList.get(i) + " Record entered.",
					Logger.DebugLevel.DATA_STRUCTURE);
			for (int j = 1; j < 9; j++) {
				// System.out.print(" " + commitFinalSubject(i, j));
				Logger.writeMsg(" " + commitFinalSubject(i, j), Logger.DebugLevel.DATA_STRUCTURE);
			}
		}
	}

	/*
	 * override the interface method to print output on the screen.
	 * 
	 */
	@Override
	public void writeSchedulesToFile(String outputFileName) {
		// TODO Auto-generated method stub
		File outputFile = new File(outputFileName);
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < this.finalResults.size(); i++) {
			try {
				// System.out.println(" "+ this.nameList.get(i));
				bw.write(this.nameList.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 1; j < 9; j++) {
				try {
					// System.out.print(" " + commitFinalSubject(i, j));
					bw.write(" " + commitFinalSubject(i, j));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bw.write("Average Preference Score : " + averagePreferenceScore());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*
	 * Constructor init the private variables
	 * 
	 */public Results() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		this.nameList = new Vector<String>(80);
		this.finalResults = new Vector<Vector<Integer>>(80);

		for (int i = 0; i < 80; i++) {
			this.nameList.add(i, new String(""));
			this.finalResults.add(i, new Vector<Integer>(10));
		}
	}

	/*
	 * Getter / Setter
	 * 
	 *
	 * @param i
	 * 
	 * @return
	 */
	public Vector<Integer> getFinalResults(int i) {
		return this.finalResults.get(i);
	}

	/*
	 * Getter / Setter
	 * 
	 * 
	 * @param i
	 * 
	 * @param j
	 * 
	 * @param value
	 */
	public synchronized void setFinalResults(int i, int j, int value) {
		// this.finalResults.get(i).get(j) = s;
		Vector<Integer> temp = new Vector<Integer>(10);
		// temp = finalResults.get(i);
		temp.add(j, value);
		this.finalResults.add(i, temp);
	}

	/*
	 * Getter / Setter
	 * 
	 * 
	 * @param i
	 * 
	 * @param row
	 */
	public synchronized void setFinalResultsRow(int i, Vector<Integer> row) {
		this.finalResults.add(i, row);
	}

	/*
	 * Getter / Setter
	 * 
	 * 
	 * @param i
	 * 
	 * @return
	 */
	public String getNameList(int i) {
		return this.nameList.get(i);
	}

	/*
	 * Getter / Setter
	 * 
	 * @param rowNumber
	 * 
	 * @param studentName
	 */

	public synchronized void setNameList(int rowNumber, String studentName) {
		this.nameList.remove(rowNumber);
		nameList.add(rowNumber, studentName);

	}

	/*
	 * Getter / Setter
	 * 
	 * 
	 * @param FinalResultIN
	 */
	public synchronized void setterFinalResults(Vector<Vector<Integer>> FinalResultIN) {
		this.finalResults = FinalResultIN;
	}

	/*
	 * Getter / Setter
	 * 
	 * @return
	 */

	public Vector<Vector<Integer>> getterFinalResults() {
		return this.finalResults;
	}

	@Override
	public String toString() {
		return "Results [nameList=" + nameList + ", finalResults=" + finalResults + ", averagePreferenceScore()="
				+ averagePreferenceScore() + ", getterFinalResults()=" + getterFinalResults() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
