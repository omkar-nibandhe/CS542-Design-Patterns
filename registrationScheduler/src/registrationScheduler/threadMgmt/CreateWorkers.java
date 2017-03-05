
package registrationScheduler.threadMgmt;

import java.io.IOException;
import java.util.Vector;

import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.util.Allocation;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.StudentObjectPool;

public class CreateWorkers {
	private FileProcessor fp;
	private Results results;
	private StudentObjectPool op;
	private Allocation businessLogic;

	// this class has the method startWokers(...)
	/*
	 * Constructor init the private variables
	 * 
	 * @param constructorfp
	 * 
	 * @param results2
	 * 
	 * @param constructorop
	 * 
	 * @param logic
	 */
	public CreateWorkers(FileProcessor constructorfp, FileDisplayInterface results2, StudentObjectPool constructorop,
			Allocation logic) {
		this.fp = constructorfp;
		this.results = (Results) results2;
		this.op = constructorop;
		this.businessLogic = logic;
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/*
	 * takes number of thread and starts each thread.
	 * 
	 * 
	 * @param numThreads
	 */
	public void startWorkers(int numThreads) {
		Thread[] threads = new Thread[numThreads];
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new Thread(new WorkerThread(fp, results, op, businessLogic));
		}
		for (int i = 0; i < numThreads; i++) {
			threads[i].start();
		}

		try {
			for (int i = 0; i < numThreads; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted with exception: " + e);
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				this.fp.reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * 
	 * Testing method
	 * 
	 * @param multi
	 */
	public void display(Vector<Vector<String>> multi) {
		System.out.println("------------");
		// TODO Auto-generated method stub
		for (int i = 0; i < multi.size(); i++) {
			System.out.println("");
			for (int j = 0; j < multi.get(i).size(); j++) {
				// System.out.println("here");
				System.out.print(multi.get(i).get(j) + "\t");
			}
		}
	}

	/**
	 * 
	 * @param results2
	 */
	public synchronized void checkStudentsForFifthSubject(FileDisplayInterface results2) {
		Vector<Vector<Integer>> temp = this.results.getterFinalResults();
		// Vector<Integer> allocationList = new Vector<Integer>(11);
		for (int i = 80 - 1; i <= 0; i++) {
			if (temp.get(i).get(9) < 5) {

			}

		}
	}

	@Override
	public String toString() {
		return "CreateWorkers [fp=" + fp + ", results=" + results + ", op=" + op + ", businessLogic=" + businessLogic
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	/*
	 * Testing method
	 * 
	 * @param result
	 */
	public void display2(Results result) {
		for (int i = 0; i < result.getterFinalResults().size(); i++) {
			System.out.print("\n->" + result.getNameList(i));
			for (int j = 0; j < result.getterFinalResults().get(i).size(); j++) {
				System.out.print("   " + result.getterFinalResults().get(i).get(j));
			}
		}
	}
}