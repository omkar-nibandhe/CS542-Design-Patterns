/**
 * 
 */
package genericDeser.driver;

import java.io.File;

import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

/**
 * @author Omkar
 *
 */
public class Driver {

	/**main method : Driver expects command line argument.
	 * @param args argument line
	 */
	public static void main(String[] args) {
		Driver d = new Driver();
		d.argumentCheck(args);
		PopulateObjects po = new PopulateObjects(args[0]);
		po.deserObjects();
		po.printResult();
		//System.out.println(po);
		
	}

	/**
	 * Check arguments and validate the input file and debug level.
	 * Expected: Driver inputFileName.txt DEBUG_VALUE
	 * @param args argument line
	 */
	private void argumentCheck(String[] args) {
		// expected argument : input.txt Debug_value
		if (args.length != 2) {
			System.out.println("Invalid arguments.\nExpected: Driver inputFileName.txt DEBUG_VALUE");
			System.exit(1);
		}
		File f = new File(args[0]);
		if (!f.exists()) {
			System.out.println(args[0] + " does not exists.");
			System.exit(1);
		}
		int debug_value = 0;
		try {
			debug_value = Integer.parseInt(args[1]);
			if (debug_value < 0) {
				System.out.println("Invalid debug value.");
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			System.err.println("Invalid debug level");
			//e.printStackTrace();
			System.exit(1);
		}
		Logger.setDebugValue(debug_value);

	}

}
