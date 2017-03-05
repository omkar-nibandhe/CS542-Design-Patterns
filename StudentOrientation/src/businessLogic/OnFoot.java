package businessLogic;

public class OnFoot implements CampusTourInterface {
	private dataStore dataStoreObject;

	/**
	 * Constructor
	 */
	public OnFoot() {
		dataStoreObject = new dataStore();
		dataStoreObject.calorieCount = 600;
		dataStoreObject.CO2 = 0.1;
		dataStoreObject.duration = 180;
		dataStoreObject.Cost = 0.10;
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
