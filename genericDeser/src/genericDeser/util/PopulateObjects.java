/**
 * 
 */
package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import genericDeser.fileOperations.FileProcessor;

/**
 * @author Omkar
 *
 */
public class PopulateObjects {
	private FileProcessor fp = null;

	private String clsName = null;
	private Class <?>cls = null;
	private Class<?>[] signature = new Class[1];
	private String methName = null;
	private Method meth = null;
	private Object obj = null;
	private Object[] param = new Object[1];
	private Object result = null;
	private Map<String, Class<?>> classType;
	private Map<Object, Integer> objectMap;

	/**
	 * Parametrised constructor takes input file name and gives it to
	 * constructor of class FileProcessor.
	 * 
	 * initialize classType (HashMap), objectMap (HashMap) initialize the
	 * classType with key/Value pairs as dataType/boxType
	 * 
	 * @param fileNameIn - the input file name.
	 */
	public PopulateObjects(String fileNameIn) {
		Logger.writeMessage("Constructor invoked: " + this.getClass().getName(), Logger.DebugLevel.CONSTRUCTOR);
		fp = new FileProcessor(fileNameIn);
		classType = new HashMap<String, Class<?>>();
		objectMap = new HashMap<Object, Integer>();
		initClassType();
	}

	/**
	 * method to initialise the hashMap with key/value as dataType/boxType
	 */
	private void initClassType() {
		classType.put("int", Integer.TYPE);
		classType.put("float", Float.TYPE);
		classType.put("short", Short.TYPE);
		classType.put("String", String.class);
		classType.put("boolean", Boolean.TYPE);
		classType.put("double", Double.TYPE);
	}

	/**
	 * Method for the requirement. reads the line from file and processes it
	 * accordingly. 1. if line has fqn then create new object. 2. else build the
	 * object with the specific value
	 */
	public void deserObjects() {

		/*
		 * Till line in input file -> read line process line. make object,
		 * create instance, create data members, create getter/setter methods,
		 * create params, and then invoke methods.
		 */
		String inputLine = "";
		int counter = 0;
		while ((inputLine = fp.getLine()) != null) {
			if (inputLine.contains("fqn:")) {
				if (counter > 0) {
					insertInMap(obj);
				}
				instintiateClass(getClassName(inputLine));
				counter++;
			} else {
				buildObject(inputLine);
			}
		}
		if (inputLine == null)
			insertInMap(obj);

	}

	/**
	 * put objects in the hashMap. if object exists then increment the value by
	 * 1 else put object in hashMap with initial value set to 1.
	 * 
	 * @param result2
	 */
	private void insertInMap(Object result2) {
		if (objectMap.containsKey(result2)) {
			objectMap.put(result2, objectMap.get(result2) + 1);
		} else {
			Logger.writeMessage("adding result to hashMap: " + this.getClass().getSimpleName() + result2,
					Logger.DebugLevel.RESULT);
			objectMap.put(result2, 1);
		}
	}

	/**
	 * builds the object with the methods and data members splits the inputLine
	 * into parts based on "="
	 * 
	 * @param inputLine
	 */
	private void buildObject(String inputLine) {
		String[] linePieces = inputLine.split(",");
		// 0 type
		// 1 var
		// 2 value
		String[] type = linePieces[0].split("=");
		String[] var = linePieces[1].split("=");
		String[] value = linePieces[2].split("=");
		signature[0] = classType.get(type[1]);
		methName = "set" + var[1];

		try {
			meth = cls.getMethod(methName, signature);
			param[0] = createParams(type[1], value[1]);
			result = meth.invoke(obj, param);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.err.println("Exception Caught. " + this.getClass().getCanonicalName());
			System.exit(1);
			e.printStackTrace();
		}
	}

	/**
	 * Generalized method to return the new box type object with value set to
	 * valueIn. converts valueIn to specif value as int, float, double etc.
	 * 
	 * @param typeIn
	 * @param valueIn
	 * @return new object of the specified class.
	 */
	private Object createParams(String typeIn, String valueIn) {
		switch (typeIn) {
		case "int":
			return new Integer(valueIn);

		case "float":
			return new Float(valueIn);

		case "double":
			return new Double(valueIn);

		case "short":
			return new Short(valueIn);

		case "String":
			;
			return new String(valueIn);

		case "boolean":
			return new Boolean(valueIn);

		default:
			System.out.println("invalud param type");
			System.exit(1);
			break;
		}
		return null;
	}

	/**
	 * Initiate the class object. takes the string for the class name (canonical
	 * name) and makes the object.
	 * 
	 * @param className
	 */
	private void instintiateClass(String className) {
		try {
			cls = Class.forName(className);
			obj = cls.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.err.println(this.getClass().getName());
			e.printStackTrace();
		}

	}

	/**
	 * split the fqn line on the basis of "." and send the class name expected
	 * First or Second
	 * 
	 * @param line
	 * @return class name
	 */
	private String getClassName(String line) {
		// TODO Auto-generated method stub
		String[] linePieces = line.split(":");
		clsName = linePieces[linePieces.length - 1];
		return clsName;
	}

	/**
	 * Method to call the compute the results and print the final results to
	 * console.
	 */
	public void printResult() {
		int[] results = getResults();

		System.out.println("Number of unique First objects: " + results[0]);
		System.out.println("Total Number of First objects: " + results[1]);
		System.out.println("Number of unique Second objects: " + results[2]);
		System.out.println("Total Number of Second objects: " + results[3]);
		
	}

	/**
	 * Computes the result and sends back the array of integers.
	 * 
	 * @return array of integer with number of unique instances, number of
	 *         instances of the class.
	 */
	private int[] getResults() {
		int[] results = { 0, 0, 0, 0 };
		// unique 1st & total 1st
		// unique 2nd & total 2nd
		Iterator<?> it = objectMap.entrySet().iterator();
		Object tempObject;
		int tempValue;
		while (it.hasNext()) {
		
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) it.next();
			tempObject = pair.getKey();
			tempValue = (int) pair.getValue();
			String classnm = tempObject.getClass().getSimpleName();
			if (classnm.equals("First")) {
				results[0]++;
				results[1] = results[1] + tempValue;
			} else {
				results[2]++;
				results[3] = results[3] + tempValue;
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
		return results;
	}

	/**
	 * Override toString method to print the object details
	 */
	@Override
	public String toString() {
		return "PopulateObjects [fp=" + fp + ", clsName=" + clsName + ", cls=" + cls + ", signature="
				+ Arrays.toString(signature) + ", methName=" + methName + ", meth=" + meth + ", obj=" + obj + ", param="
				+ Arrays.toString(param) + ", result=" + result + ", classType=" + classType + ", objectMap="
				+ objectMap + "]";
		 
	}

}
