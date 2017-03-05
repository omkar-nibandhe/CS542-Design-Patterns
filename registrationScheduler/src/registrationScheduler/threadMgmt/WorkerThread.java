
package registrationScheduler.threadMgmt;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import registrationScheduler.store.Results;
import registrationScheduler.util.Allocation;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.StudentObjectPool;

public class WorkerThread implements Runnable {

	private FileProcessor fp;
	private Results result;
	private StudentObjectPool op;
	private Allocation logic;

	/*
	 * Constructor init the private variables
	 * 
	 */
	public WorkerThread(FileProcessor fp, Results results, StudentObjectPool op, Allocation businessLogic) {
		// TODO Auto-generated constructor stub
		this.fp = fp;
		this.result = results;
		this.op = op;
		this.logic = businessLogic;
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	public void run() {

		Logger.writeMessage("Thread running: " + this.getClass().getName(), Logger.DebugLevel.THREAD);
		String line = " ";
		// read line from input file & run the algorithm
		// store results in data structure of Result instance
		while ((line = fp.getLine()) != null) {
			inputEntryThreaded(line, fp, result);
			logic.applyBusinessLogic(result, op);
		}
	}

	/*
	 * Read line by line the input file Put in the data structure in store
	 * maintain vector<vecotr<Integer>> for preference maintain vector<string>
	 * for subject name
	 *
	 * @param line
	 * 
	 * @param fp2
	 * 
	 * @param result2
	 */
	private void inputEntryThreaded(String line, FileProcessor fp2, Results result2) {
		// TODO Auto-generated method stub
		try {
			Vector<String> newTemp = new Vector<String>(10);

			String[] newString = line.split("\\s+");
			if (newString.length < 8) {
				System.out.println("Error in input file.");
			}
			newTemp.add(0, newString[0]);

			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(newString[0]);
			m.find();
			int student_id = Integer.parseInt(m.group());
			Vector<Integer> integerTemp = result2.getFinalResults(student_id - 1);

			integerTemp.add(0, student_id);

			int i;
			for (i = 1; i < newString.length; i++) {
				newTemp.add(i, newString[i]);
				integerTemp.add(i, Integer.parseInt(newString[i]));
				// System.out.print("\t->"+newString[i]);
			}

			integerTemp.add(i++, 0);
			integerTemp.add(i++, 0);
			integerTemp.add(i++, 0);

			synchronized (this) {
				fp2.multi.add(newTemp);
				result2.setNameList(student_id - 1, newString[0]);
				// result2.setFinalResultsRow(student_id - 1, integerTemp);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Number Format Exception caught. Exiting");
			System.exit(1);
		} finally {

		}
	}

	@Override
	public String toString() {
		return "WorkerThread [fp=" + fp + ", result=" + result + ", op=" + op + ", logic=" + logic + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}