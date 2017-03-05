/**
 * 
 */
package businessLogic;

/**
 * @author Omkar
 *
 */
public class MandoBooks implements BookStoreInterface {

	private dataStore dataStoreObject;
	
	public MandoBooks(){
		dataStoreObject = new dataStore();
		dataStoreObject.calorieCount = 150;
		dataStoreObject.CO2 = 0.3;
		dataStoreObject.duration = 30;
		dataStoreObject.Cost = costI * 1.05;
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
