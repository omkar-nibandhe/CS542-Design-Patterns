package registrationScheduler.util;

import java.util.Vector;

import registrationScheduler.store.Results;

public class Allocation {

	/*
	 * Constructor init the private variables
	 * 
	 */
	public Allocation() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
	}

	/*
	 * check available if yes then return true.
	 * 
	 * @param coursename
	 * 
	 * @param op
	 * 
	 * @return
	 */
	public synchronized boolean checkAvailability(String coursename, StudentObjectPool op) {
		// System.out.println("coursename is : " + coursename);
		Course temp = op.borrowStudentObject(coursename);
		if (temp.getSeats() > 0) {
			op.returnStudentObject(coursename);
			return true;
		} else {
			op.returnStudentObject(coursename);
			return false;
		}
	}

	/*
	 * Borrow object and allocate subject from the object pool return the objct
	 * after decreasing seat.
	 * 
	 * @param coursename
	 * 
	 * @param op
	 */
	public synchronized void allocateSubject(String coursename, StudentObjectPool op) {
		Course temp = op.borrowStudentObject(coursename);
		temp.setSeats(temp.getSeats() - 1);
	}

	/*
	 * Borrow object and allocate subject from the object pool return the objct
	 * after increasing seat.
	 * 
	 * @param coursename
	 * 
	 * @param op
	 */
	public synchronized void deallocateSubject(String coursename, StudentObjectPool op) {
		Course temp = op.borrowStudentObject(coursename);
		temp.setSeats(temp.getSeats() + 1);
	}

	/*
	 * Allocation logic.
	 * 
	 * 
	 * 
	 * @param result
	 * 
	 * @param op
	 */
	public synchronized void applyBusinessLogic(Results result, StudentObjectPool op) {
		Vector<Vector<Integer>> temp = result.getterFinalResults();
		Vector<Integer> allocationList = new Vector<Integer>(11);

		for (int i = 0; i < temp.size(); i++) {
			allocationList = temp.get(i);
			// System.out.println("->"+allocationList.get(10));
			if (!allocationList.isEmpty() && allocationList.size() > 10) {
				if (allocationList.size() < 1) {
					break;
				}
				int c = allocationList.get(10);
				if (c == 0) {
					int subjectPreferenceNumber = 1;
					while (subjectPreferenceNumber < 8) {
						for (int j = 1; j <= 7; j++) {
							if ((allocationList.get(j) == subjectPreferenceNumber) && (allocationList.get(9) < 5)) {
								int courseNameInASCII = 64 + j;
								String courseName = new Character((char) courseNameInASCII).toString();
								if (checkAvailability(courseName, op)) {
									allocateSubject(courseName, op);
									int newCount = allocationList.get(9);
									allocationList.remove(9);
									allocationList.add(9, newCount + 1);
									newCount = allocationList.get(8);
									allocationList.remove(8);
									allocationList.add(8, newCount + subjectPreferenceNumber);
									newCount = allocationList.get(j);
									allocationList.remove(j);
									allocationList.add(j, newCount * (-1));
									op.returnStudentObject(courseName);
									newCount = 1;
									allocationList.remove(10);
									allocationList.add(10, newCount);
								}
							}
						}
						subjectPreferenceNumber++;
					}
					temp.remove(i);
					temp.add(i, allocationList);
					Logger.writeMessage("Logger invoked: " + result.getFinalResults(i), Logger.DebugLevel.RESULT);
				}
			}
		}
		result.setterFinalResults(temp);
	}

	@Override
	public String toString() {
		return "Allocation [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
