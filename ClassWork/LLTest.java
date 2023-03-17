import javax.swing.JOptionPane;

// M Madden, January 2008

public class LLTest 
{
	public static void main(String[] args)
	{
		// Create a linked list
		
		SLinkedList list = new SLinkedList();

		JOptionPane.showMessageDialog(null, "List initially empty - current item is: " + list.getCurr());

		// Add some items to the list
		list.insertNext("I"); 
		list.insertNext("love");
		list.insertNext("Java");
		list.insertNext("programming");
		display(list);

		// test: delete tail node
		list.gotoHead();
		list.gotoNext();
		list.gotoNext();
		list.deleteNext(); // this should delete 4th of 4 elements
		display(list);

		list.insertNext("class");
		JOptionPane.showMessageDialog(null, "Tail is: " + list.getCurr());
		
		list.gotoHead();
		list.insertNext("don't");
		display(list);
		
		list.gotoHead();
		list.gotoNext();
		list.gotoNext();
		list.deleteNext();
		display(list);
		
		list.deleteHead();
		list.insertHead("You");
		display(list);
		
		JOptionPane.showMessageDialog(null, "Size of list = " + list.size());
	}

	public static void display(SLinkedList list)
	{
		String alltext = "";
		boolean haveNode = list.gotoHead();
		while (haveNode)
		{
			alltext += " " + list.getCurr();
			haveNode = list.gotoNext();
		}
		JOptionPane.showMessageDialog(null,
				"Full List (" + list.size() + " els): " + alltext);
	}

}