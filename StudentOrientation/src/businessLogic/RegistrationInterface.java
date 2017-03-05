package businessLogic;

import studentOrientation.store.CaloriesInterface;
import studentOrientation.store.CarbonFootPrintInterface;
import studentOrientation.store.CostInterface;
import studentOrientation.store.DurationInterface;

public interface RegistrationInterface extends CaloriesInterface, CarbonFootPrintInterface, CostInterface, DurationInterface {
	static final double costI = 90;

}
