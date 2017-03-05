/**
 * 
 */
package studentOrientation.util;

import studentOrientation.driver.Driver.activityChoice;
import studentOrientation.store.orientationWorkshopI;

/**
 * @author Omkar
 *
 */
public class studentOrientationWorkshop implements orientationWorkshopI {

	@Override
	public void construct(Orientation orientObject, activityChoice choice1, activityChoice choice2,
			activityChoice choice3, activityChoice choice4) {

		constructAcitivityChoice(orientObject, choice1);
		constructAcitivityChoice(orientObject, choice2);
		constructAcitivityChoice(orientObject, choice3);
		constructAcitivityChoice(orientObject, choice4);
		orientObject.displayResult();
	}

	/**
	 * 
	 * @param orientObject
	 * @param mychoice
	 */
	private void constructAcitivityChoice(Orientation orientObject, activityChoice mychoice) {
		switch (mychoice) {
		case BOOKSTORE:
			orientObject.buildBookStore();
			break;
		case CAMPUSTOUR:
			orientObject.buildCampusTour();
			break;
		case DORMS:
			orientObject.buildDorms();
			break;
		case REGISTRATION:
			orientObject.buildRegistration();
			break;

		default:
			// Logger call.
			break;
		}
	}

}
