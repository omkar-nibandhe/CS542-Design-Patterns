package businessLogic;

/**
 * @author Omkar
 *
 */
public class BusRide implements CampusTourInterface{

private dataStore dataStoreObject;
	
	public BusRide(){
		dataStoreObject = new dataStore();
		dataStoreObject.calorieCount = 100;
		dataStoreObject.CO2 = 0.4;
		dataStoreObject.duration = 60;
		dataStoreObject.Cost = 2;
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
