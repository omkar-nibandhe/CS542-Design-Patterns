package wordCount.driver;

import java.io.File;
import java.io.IOException;

import wordCount.BinarySearchTreesForStrings.BSTree;
import wordCount.BinarySearchTreesForStrings.TreeInterface;
import wordCount.visitors.CloneAndObserveVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.ValueIncrementorVisitor;
import wordCount.visitors.WordCountVisitor;
/**
 * 
 * @author Omkar Nibandhe
 * Mar 5, 2017 	
 * https://www.linkedin.com/in/omkarnibandhe
 */
public class Driver {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		Driver d = new Driver();
		d.argumentChecker(args);
		TreeInterface BSTree = null;
		TreeProcessingVisitorI PopulatorVisitor = null;
		TreeProcessingVisitorI wc = null;
		TreeProcessingVisitorI backup = null;

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < Integer.parseInt(args[2]); i++) {
			BSTree = new BSTree();
			PopulatorVisitor = new PopulateVisitor(args[0]);
			wc = new WordCountVisitor(args[1]);
			BSTree.accept(PopulatorVisitor);
			BSTree.accept(wc);
		}
		long finishTime = System.currentTimeMillis();

		System.out.println("Total Time: " + (finishTime - startTime) + " milliseconds");

		TreeInterface BSTreeBackup = new BSTree();
		backup = new CloneAndObserveVisitor(BSTreeBackup);
		BSTree.accept(backup);

		TreeProcessingVisitorI incrementValue = new ValueIncrementorVisitor(1);
		BSTree.accept(incrementValue);
		BSTree.printInorderToFile("testFile1.txt");
		BSTreeBackup.printInorderToFile("testFile2.txt");
		/*
		 * try { Runtime.getRuntime().
		 * exec("/bin/bash -c diff testFile1.txt testFile2.txt"); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.exit(1); }finally{
		 * 
		 * }
		 */
	}

	/**
	 * 
	 * @param args
	 *            : String[]
	 */
	private void argumentChecker(String[] args) {
		if (args.length != 3) {
			System.out.println("Expecting Arguments: Driver inputFileName.txt outputFileName.txt NumberOfIterations");
			System.exit(1);
		}
		try {
			if (Integer.parseInt(args[2]) < 0) {
				System.out.println("invalid number of arguments.");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("invalid digit");
			System.exit(1);

		}
		File newFile = new File(args[0]);
		File newFileOutput = new File(args[1]);
		if (!newFile.exists()) {
			System.out.println("Input file not found: " + args[0]);
			System.out.println("Exiting.");
			System.exit(1);
		}
		if (!newFileOutput.exists()) {
			try {
				newFileOutput.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error creating new file.");
				System.exit(1);
			} finally {

			}
		}
	}
}
