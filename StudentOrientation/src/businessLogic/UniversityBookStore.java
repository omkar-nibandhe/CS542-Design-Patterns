/**
 * 
 */
package businessLogic;

/**
 * @author Omkar
 *
 */
public class UniversityBookStore implements BookStoreInterface {

	private dataStore dataStoreObject;
	/**
	 * Constructor
	 */
	public UniversityBookStore() {
		// TODO Auto-generated constructor stub

		dataStoreObject = new dataStore();
		dataStoreObject.calorieCount = 50;
		dataStoreObject.CO2 = 0.1;
		dataStoreObject.duration = 60;
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
