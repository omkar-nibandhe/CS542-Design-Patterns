package wordCount.visitors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import wordCount.BinarySearchTreesForStrings.TreeInterface;

public class PopulateVisitor implements TreeProcessingVisitorI {

	private BufferedReader fileReader = null;

	/**
	 * 
	 * @param fileReaderIn
	 */
	public PopulateVisitor(String fileReaderIn) {
		// TODO Auto-generated constructor stub
		try {
			fileReader = new BufferedReader(new FileReader(fileReaderIn));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("exiting");
			System.exit(1);
		} finally {

		}
	}

	/**
	 * @param bsTree
	 *            : TreeInterface
	 */
	@Override
	public void visit(TreeInterface bsTree) {
		// TODO Auto-generated method stub
		// List<String> lines = new LinkedList<String>();
		String line = "";
		try {
			int count = 0;
			while (((line = fileReader.readLine()) != null)) {
				String[] s = line.split("\\s+");
				count = s.length;
				for (int i = 0; i < count; i++) {
					bsTree.insert(s[i]);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exiting.");
			System.exit(1);
		} finally {

		}

	}

}
