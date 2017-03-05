/**
 * 
 */
package businessLogic;

/**
 * @author Omkar
 *
 */
public class RegistrationSelf implements RegistrationInterface {

	private dataStore dataStoreObject;

	/**
	 * Constructor
	 */
	public RegistrationSelf() {
		dataStoreObject = new dataStore();
		dataStoreObject.calorieCount = 75;
		dataStoreObject.CO2 = 0.3;
		dataStoreObject.duration = 15;
		dataStoreObject.Cost = costI * 1;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return dataStoreObject.duration;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return dataStoreObject.Cost;
	}

	@Override
	public double getCarbonCount() {
		// TODO Auto-generated method stub
		return dataStoreObject.CO2;
	}

	@Override
	public int getCalorieCount() {
		// TODO Auto-generated method stub
		return dataStoreObject.calorieCount;
	}
}
