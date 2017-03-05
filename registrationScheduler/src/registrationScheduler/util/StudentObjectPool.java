package registrationScheduler.util;

public class StudentObjectPool {

	private Course CourseA, CourseB, CourseC, CourseD, CourseE, CourseF, CourseG;
	private boolean isAvailableA = true, isAvailableB = true, isAvailableC = true, isAvailableD = true,
			isAvailableE = true, isAvailableF = true, isAvailableG = true;

	public StudentObjectPool() {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		setStudentFactory();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Course addStudentObject(String name) {
		return (new Course(name));
	}

	public void setStudentFactory() {
		CourseA = addStudentObject("A");
		CourseB = addStudentObject("B");
		CourseC = addStudentObject("C");
		CourseD = addStudentObject("D");
		CourseE = addStudentObject("E");
		CourseF = addStudentObject("F");
		CourseG = addStudentObject("G");
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Course borrowStudentObject(String name) {
		switch (name) {
		case "A":
			if (isAvailableA) {
				isAvailableA = false;
				return CourseA;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;
		case "B":
			if (isAvailableB) {
				isAvailableB = false;
				return CourseB;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;
		case "C":
			if (isAvailableC) {
				isAvailableC = false;
				return CourseC;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;
		case "D":
			if (isAvailableD) {
				isAvailableD = false;
				return CourseD;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;

		case "E":
			if (isAvailableE) {
				isAvailableE = false;
				return CourseE;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;

		case "F":
			if (isAvailableF) {
				isAvailableF = false;
				return CourseF;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;
		case "G":
			if (isAvailableG) {
				isAvailableG = false;
				return CourseG;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
				borrowStudentObject(name);
			}
			break;

		default:
			System.out.println("Invalid name for borrowObject");
			break;
		}
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public void returnStudentObject(String name) {
		switch (name) {
		case "A":
			isAvailableA = true;
			break;

		case "B":
			isAvailableB = true;
			break;

		case "C":
			isAvailableC = true;
			break;

		case "D":
			isAvailableD = true;
			break;

		case "E":
			isAvailableE = true;
			break;

		case "F":
			isAvailableF = true;
			break;

		case "G":
			isAvailableG = true;
			break;

		default:
			System.out.println("Invalid object returned");
			break;
		}
	}

}
