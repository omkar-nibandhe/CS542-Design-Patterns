package wordCount.visitors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import wordCount.BinarySearchTreesForStrings.BSTNode;
import wordCount.BinarySearchTreesForStrings.NodeInterface;
import wordCount.BinarySearchTreesForStrings.TreeInterface;

public class WordCountVisitor implements TreeProcessingVisitorI {
	// private NodeInterface rootNode = null;
	private BufferedWriter fileWriter = null;

	/**
	 * 
	 */
	public WordCountVisitor(String outputFileName) {
		// TODO Auto-generated constructor stub
		try {

			fileWriter = new BufferedWriter(new FileWriter(new File(outputFileName)));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exiting");
			System.exit(1);

		} finally {
		}

	}

	/**
	 * @param BSTree
	 *            : TreeInterface
	 */
	@Override
	public void visit(TreeInterface BSTree) {
		int totalWords = 0;
		int distinctWords = 0;
		int characters = 0;
		NodeInterface rootNode = BSTree.getRootNode();
		if (rootNode == null) {
			return;
		}
		Stack<BSTNode> s = new Stack<BSTNode>();
		NodeInterface currentNode = rootNode;
		while (!s.empty() || currentNode != null) {
			if (currentNode != null) {
				s.push((BSTNode) currentNode);
				currentNode = currentNode.getLeftChild();
			} else {
				NodeInterface n = s.pop();
				// System.out.println(n.getWord() + " " + n.getNoOccurences());
				if (!n.getWord().isEmpty()) {
					distinctWords = distinctWords + 1;
					totalWords = (totalWords + n.getNoOccurences());
					characters = (characters + (n.getNoCharacters() * n.getNoOccurences()));
				}
				currentNode = n.getRightChild();
			}
		}
		String outputString = "totalWords : " + totalWords + "\ndistinctWords : " + distinctWords + "\ncharacters : "
				+ characters;
		writeToFile(outputString);

	}

	/**
	 * 
	 * @param outputString
	 */
	public void writeToFile(String outputString) {
		try {
			fileWriter.write(outputString);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(outputString);
		}
	}

}
