package studentOrientation.driver;

import studentOrientation.store.orientationWorkshopI;
import studentOrientation.util.Orientation;
import studentOrientation.util.studentOrientationWorkshop;

public class Driver {
	/**
	 * 
	 * @author Omkar Nibandhe Mar 5, 2017
	 *         https://www.linkedin.com/in/omkarnibandhe
	 */
	public static enum ParamNames {
		BUSRIDE, ONFOOT, UNIVERSITYBOOKSTORE, MANDOBOOKS, DORMOFFLINE, DORMONLINE, REGISTERATIONOFFICE, REGISTERATIONSELF
	};

	public static enum activityChoice {
		CAMPUSTOUR, BOOKSTORE, REGISTRATION, DORMS
	};

	/**
	 * @param args Command Line String[]
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Orientation orientObject = new Orientation(ParamNames.ONFOOT, ParamNames.UNIVERSITYBOOKSTORE,
				ParamNames.DORMOFFLINE, ParamNames.REGISTERATIONOFFICE);
		orientationWorkshopI workshop = new studentOrientationWorkshop();
		workshop.construct(orientObject, activityChoice.CAMPUSTOUR, activityChoice.BOOKSTORE,
				activityChoice.REGISTRATION, activityChoice.DORMS);
		System.out.println("Run success.");
	}

}
