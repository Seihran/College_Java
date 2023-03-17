import java.io.*;
import javax.swing.*;
/**
 * A program that creates, modifies, saves and loads a binary tree that incorporates a guessing game of world wonders
 * 
 * @author Ciarán McCarthy
 * 1/4/2020
 */
public class Game
{
	//Creates a global variable of the saved file location
	public static File f = new File("C:/Users/Public/tree.ser");
	public static BinaryTree<String> tree = new BinaryTree<String>("");
	public static void main(String[] args)
	{
		//createTree(tree);
		display(tree);
		//An array of main menu options
		String[] options = {"Play", "Rules", "Save", "Load", "Quit"};
		//Game loops continuously until an exit command is run, i.e. Quit is selected
	    while (true)
	    {
	    	//Creates a pane with the options to act as a main menu
	    	int choice = JOptionPane.showOptionDialog(null, "Do you want to play?",
	    			"Wonders of the World - Guessing Game",
	    	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	    	        null, options, options[0]);
	    	//A series of if else statements for each of the options
	    	    if (choice == 0)
	    	    {
	    	    	//If option one, "Play" is selected and no tree has been loaded or this is the first time the game
	    	    	//is being played, creates a tree based on the initial configuration
	    	    	if (tree.getRootData().compareTo("") == 0)
	    	    	{
	    	    		tree = createTree(tree);
	    	    	}
	    	    	//Runs the play method
	    	    	play(tree);
	    	    }
	    	    else if (choice == 1)
	    	    {
	    	    	//Displays the rules of the game if selected
	    	    	JOptionPane.showMessageDialog(null, "The aim of this game is to think of a wonder of the world.\n"
	    	    			+ "Then through a series of Yes or No questions, the game will try to guess which one you are thinking of.\n"
	    	    			+ "If the game gets it wrong, you will be given the opportunity to input the correct answer and a question.\n"
	    	    			+ "This question will allow it to determine the difference between its initial answer and the correct one.\n"
	    	    			+ "You will then be able to save and load this new configuration for future games.");
	    	    }
	    	    else if (choice == 2)
	    	    {
	    	    	//Saves the current configuration of the tree to a file unless the tree is empty
	    	    	if (tree.getRootData().compareTo("") == 0)
	    	    	{
	    	    		JOptionPane.showMessageDialog(null, "You have nothing to save, you haven't played yet!");
	    	    	}
	    	    	else
	    	    	{
	    	    		save(tree);
	    	    		JOptionPane.showMessageDialog(null, "Tree has been saved.");
	    	    	}
	    	    }
	    	    else if (choice == 3)
	    	    {
	    	    	//Loads a tree from a file only if one exists
	    	    	if (f.exists())
	    	    	{
	    	    		load();
	    	    		JOptionPane.showMessageDialog(null, "Tree has been loaded.");
	    	    		display(tree);
	    	    	}
	    	    	else
	    	    	{
	    	    		JOptionPane.showMessageDialog(null, "No file exists yet, play the game to create one.");
	    	    	}
	    	    }
	    	    else
	    	    {
	    	    	//Quits the game
	    	    	System.exit(0);
	    	    }
	    }
	}
	
	public static BinaryTree<String> createTree(BinaryTree<String> root)
	{
		//The initial configuration for the tree
		//Creates two arrays and populates them with some questions and answers
		String[] questions = {"Is it man made?", "Is it more than 500 years old?",
				"Is it in Europe?", "Is it a museum?", "Does it involve water?",
				"Is it a waterfall?", "Is it a mountain?"};
		String[] answers = {"Colosseum of Rome", "Chichen Itza", "Louvre museum",
				"Taj Mahal", "Victoria Falls", "Li River", "Matterhorn", "Sahara desert"};
		//Creates a series of nodes and connects them to each other and fills them with the appropriate questions and answers
		BinaryNode<String> leftNode3 = new BinaryNode<String>(answers[0]);
		BinaryNode<String> leftNode4 = new BinaryNode<String>(answers[2]);
		BinaryNode<String> leftNode6 = new BinaryNode<String>(answers[4]);
		BinaryNode<String> leftNode7 = new BinaryNode<String>(answers[6]);
		BinaryNode<String> rightNode1 = new BinaryNode<String>(answers[1]);
		BinaryNode<String> rightNode3 = new BinaryNode<String>(answers[3]);
		BinaryNode<String> rightNode5 = new BinaryNode<String>(answers[5]);
		BinaryNode<String> rightNode7 = new BinaryNode<String>(answers[7]);
		BinaryNode<String> leftNode2 = new BinaryNode<String>(questions[2], leftNode3, rightNode1);
		BinaryNode<String> leftNode5 = new BinaryNode<String>(questions[5], leftNode6, rightNode5);
		BinaryNode<String> rightNode2 = new BinaryNode<String>(questions[3], leftNode4, rightNode3);
		BinaryNode<String> rightNode6 = new BinaryNode<String>(questions[6], leftNode7, rightNode7);
		BinaryNode<String> rightNode4 = new BinaryNode<String>(questions[4], leftNode5, rightNode6);
		BinaryNode<String> leftNode1 = new BinaryNode<String>(questions[1], leftNode2, rightNode2);
		BinaryNode<String> rootNode = new BinaryNode<String>(questions[0], leftNode1, rightNode4);
		root.setRootNode(rootNode);
		//Returns the completed tree
		return root;
	}
	
	public static void save(BinaryTree<String> tree)
	{
		//Uses serialisation to save the tree to a file
		try
    	{
			OutputStream file = new FileOutputStream("Users/Public/tree.ser");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			output.writeObject(tree);
			output.close();
		}
		//Catches exceptions
    	catch (IOException e)
    	{
			e.printStackTrace();
		}
	}
	
	//Suppresses warnings about an unchecked casting from object to binary tree type
	@SuppressWarnings("unchecked")
	public static BinaryTree<String> load()
	{
		//Loads a file and casts it to a tree
		try
    	{
			InputStream file = new FileInputStream("C:/Users/Public/tree.ser");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			tree = (BinaryTree<String>) input.readObject();
			input.close();
		}
		//Catches exceptions from IO and classes not found
    	catch (IOException | ClassNotFoundException e)
    	{
			e.printStackTrace();
		}
		return tree;
	}
	
	public static void play(BinaryTree<String> tree)
	{
		//Creates a node that copies the root node of the tree
		BinaryNodeInterface<String> current = tree.getRootNode();
		//While the current node is not a leaf node, requests input from user
		while (!current.isLeaf())
		{
			//If the user responds with Yes, assigns the current node to be the left child node of the current node
			if (response(current.getData()))
			{
				current = current.getLeftChild();
			}
			//If the user responds with No, assigns the current node to be the right child node of the current node
			else
			{
				current = current.getRightChild();
			}
		}
		//Once a leaf node is reached, requests the user to answer if the guess is correct or not
		if (response("Are you thinking of the " + current.getData() + "?"))
		{
			JOptionPane.showMessageDialog(null, "I knew it!");
		}
		//If the guess was wrong, launches an update method to change the tree
		else
		{
			update(current);
		}
	}
	
	public static void update(BinaryNodeInterface<String> current)
	{
		//Assigns the current(wrong) guess to a value and requests the correct answer
		String currentAnswer = current.getData();
		String newAnswer = JOptionPane.showInputDialog(null, "I was wrong, what are you thinking of?");
		//If the user does not enter an answer or the answer is blank, continuously requests one
		while (newAnswer == null || newAnswer.isBlank())
		{
			newAnswer = JOptionPane.showInputDialog(null, "Please enter an answer.");
			//If the user selects cancel twice, returns to main menu
			if (newAnswer == null)
			{
				main(null);
			}
		}
		//Requests a new question to differentiate between the two answers
		String newQuestion = JOptionPane.showInputDialog(null,
				"Please enter a Yes/No question to distinguish between " + currentAnswer + " and " + newAnswer + ":");
		while (newQuestion == null || newQuestion.isBlank())
		{
			newQuestion = JOptionPane.showInputDialog(null, "Please enter a question.");
			if (newQuestion == null)
			{
				main(null);
			}
		}
		//Sets the current nodes data to be the new question
		current.setData(newQuestion + "?");
		//Requests the user for clarification about whether the new answer is a yes or no response to the new question
		if (response(newQuestion + ",   " + newAnswer + "\nIs this statement true?"))
		{
			//If yes, sets the new answer to be the left child and the old answer to be the right child
			current.setLeftChild(new BinaryNode<String>(newAnswer));
			current.setRightChild(new BinaryNode<String>(currentAnswer));
		}
		else
		{
			//If no, sets the old answer to be the left child and the new answer to be the right child
			current.setLeftChild(new BinaryNode<String>(currentAnswer));
			current.setRightChild(new BinaryNode<String>(newAnswer));
		}
	}
	
	public static boolean response(String input)
	{
		//Requests a yes or no response from the user
		int answer = JOptionPane.showConfirmDialog(null, input);
		//If cancel is selected, returns to the main menu
		if (answer != 0 && answer != 1)
		{
			main(null);
		}
		//If yes is selected, returns true
		else if (answer == 0)
		{
			return true;
		}
		//Else returns false
		return false;
	}
	
	public static void display(BinaryTree<String> disTree)
	{
		//For testing purposes
		//Prints to the console an image of the base tree that is created by default and displays the number of nodes,
		//the height and an in order traversal of all of the nodes
		String[] questions = {"Is it man made?", "Is it more than 500 years old?",
				"Is it in Europe?", "Is it a museum?", "Does it involve water?",
				"Is it a waterfall?", "Is it a mountain?"};
		String[] answers = {"Colosseum of Rome", "Chichen Itza", "Louvre museum",
				"Taj Mahal", "Victoria Falls", "Li River", "Matterhorn", "Sahara desert"};
		System.out.println("Tree will look like this:\n");
	  	System.out.println("       							  		    " + questions[0] + "              ");
	    System.out.println("    					  / 									        \\        ");
	    System.out.println("    			  " + questions[1] + "	    		        		      " + questions[4] + "        ");
	    System.out.println(" 			  /   				\\   						    / 			    \\    ");
	    System.out.println("  		" + questions[2] + "  		   " + questions[3] + "   				  " + questions[5] + "   	      " + questions[6] + "    ");
	    System.out.println("		 / 		\\ 		 /		 \\ 				  /		 \\ 	      /		     \\");
	    System.out.println("   " + answers[0] + "	   " + answers[1] + "   " + answers[2] + "     " + answers[3]
	    		+ "			 " + answers[4] + "      " + answers[5] + "	" + answers[6] + "      " + answers[7] + "  ");
	    System.out.println();
	    System.out.println(disTree.getNumberOfNodes());
	    System.out.println(disTree.getHeight());
	    disTree.inorderTraverse();
	}
}