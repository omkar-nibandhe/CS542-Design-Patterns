
package registrationScheduler.driver;

import java.io.File;
import java.io.IOException;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.Allocation;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.StudentObjectPool;

/**
 * 
 * @author Omkar Nibandhe Mar 5, 2017 https://www.linkedin.com/in/omkarnibandhe
 */
public class Driver {
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Driver d = new Driver();
		d.sanitoryChecks(args);
		FileProcessor fp = new FileProcessor(args);
		FileDisplayInterface results = new Results();
		StudentObjectPool op = new StudentObjectPool();
		Allocation businessLogic = new Allocation();
		CreateWorkers cw = new CreateWorkers(fp, results, op, businessLogic);
		cw.startWorkers(Integer.parseInt(args[2]));
		// cw.checkStudentsForFifthSubject(results);
		results.writeSchedulesToFile(fp.getOutputFileName());
		StdoutDisplayInterface castingInstance;
		castingInstance = (StdoutDisplayInterface) results;

		castingInstance.writeScheduleToScreen();

		System.out.println("\nAverage Preference Score : " + results.averagePreferenceScore());
	} // end main(...)

	public Driver() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/*
	 * method that checks input arguments
	 * 
	 * @param args
	 */

	public void sanitoryChecks(String[] args) {
		if (args.length != 4) {
			System.out.println("Invalid Arguments.\nExpected: driver input.txt output.txt 3 1\nExiting.");
			System.exit(1);
		}
		File newFile = new File(args[0]);
		if (!newFile.exists()) {
			System.out.println("Input file not found: " + args[0]);
			System.out.println("Exiting.");
			System.exit(1);
		}
		// InputFileName = args[0];
		File newFileOutput = new File(args[1]);
		if (!newFileOutput.exists()) {
			try {
				newFileOutput.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error creating new file.");
				System.exit(1);
			} finally {
			}
		}
		// OutputFileName = args[1];
		if (Integer.parseInt(args[2]) > 3 || Integer.parseInt(args[2]) < 1) {
			System.out.println("Invalid number of threads.\nExiting.");
			System.exit(1);
		}
		// numThread = Integer.parseInt(args[2]);
		if (Integer.parseInt(args[3]) < 0 || Integer.parseInt(args[3]) > 4) {
			System.out.println("Invalid Logger level.\nExiting.");
			System.exit(1);
		}
		Logger.setDebugValue(Integer.parseInt(args[3]));
	}

	@Override
	public String toString() {
		return "Driver [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
} // end public class Driver
