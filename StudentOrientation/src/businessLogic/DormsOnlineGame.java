/**
 * 
 */
package businessLogic;

/**
 * @author Omkar
 *
 */
public class DormsOnlineGame implements DormsInterface {

	private dataStore dataStoreObject;

	public DormsOnlineGame() {
		dataStoreObject = new dataStore();
		dataStoreObject.calorieCount = 30;
		dataStoreObject.CO2 = 0.2;
		dataStoreObject.duration = 20;
		dataStoreObject.Cost = costI * 1.02;
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
