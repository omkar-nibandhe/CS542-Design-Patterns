package businessLogic;

import studentOrientation.store.CaloriesInterface;
import studentOrientation.store.CarbonFootPrintInterface;
import studentOrientation.store.CostInterface;
import studentOrientation.store.DurationInterface;


public interface DormsInterface extends CaloriesInterface, CarbonFootPrintInterface, CostInterface, DurationInterface {

		static final double costI = 20.0;
}
