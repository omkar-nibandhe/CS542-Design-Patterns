package studentOrientation.store;

import studentOrientation.driver.Driver.activityChoice;
import studentOrientation.util.Orientation;

public interface orientationWorkshopI {

	void construct(Orientation orientObject, activityChoice choice1, activityChoice choice2, activityChoice choice3, activityChoice choice4);

}
