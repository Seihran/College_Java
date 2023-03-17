/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (06/11/2020)
 * 
 * Creates scrollable tabbed pane to display outputs from main class
*/

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class OutputGUI
{
	ArrayList<JComponent> panels;
	JTabbedPane tabbedPane;
	private boolean tabCreated = false;
	
	//Constructor that creates arraylist to hold panels
	public OutputGUI()
	{
		panels = new ArrayList<JComponent>();
	}
	
	//Creates panels filled with text areas of given string
	public void addTextArea(String s)
	{
		//Creates text area with string
		JTextArea textArea = new JTextArea(s);
		//Creates vertical box for text area
		Box box = Box.createVerticalBox();
		box.add(textArea);
		//Creates panel for box
		JPanel panel = new JPanel();
		panel.add(box);
		//Adds panel to arraylist
		panels.add(panel);
	}
	
	//Add scroll bar to already created text panel
	public void addScroll(int panelNum, int horDim, int verDim)
	{
		//Check if arraylist is empty
		if (panels.isEmpty())
		{
			System.out.println("No text areas created.");
		}
		else
		{
			//Checks if provided panel number was created
			try
			{
				//Creates scroll pane of specified panel
				JScrollPane scroll = new JScrollPane(panels.get(panelNum));
				//Sets dimensions to ones provided
				scroll.setPreferredSize(new Dimension(horDim, verDim));
				//Replaces panel in arraylist with scroll one
				panels.set(panelNum, scroll);
				//Returns successful message and number of panel changed
				System.out.println("Scroll bar added to text area " + panelNum);
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.println("That panel is empty,");
			}
		}
	}
	
	//Creates tabbed pane
	public void createTab(String[] tabName)
	{
		tabbedPane = new JTabbedPane();
		//Adds existing panels to tabs with titles given
		if (panels.size() != tabName.length)
		{
			System.out.println("Not enough titles for existing panels,\n"
					           + "only tabs with titles can be created,\n"
					           + "if no titles given, no tab will be created.");
		}
		else
		{
			for (int i=0; i<tabName.length; i++)
			{
				tabbedPane.addTab(tabName[i], panels.get(i));
			}
			//Sets flag that tabbed pane was created
			tabCreated = true;
		}
	}
	
	public void display(String title)
	{
		//If tab created, displays as information message
		if (tabCreated)
		{
			JOptionPane.showMessageDialog(null, tabbedPane, title,  
										  JOptionPane.INFORMATION_MESSAGE);
		}
		//If no tab was created, displays panels as grid information message
		else
		{
			JPanel panel = new JPanel(new GridLayout(0, 2));
			//Sets panels in arraylist to one panel
			for (int i=0; i<panels.size(); i++)
			{
				panel.add(panels.get(i));
			}
			JOptionPane.showMessageDialog(null, panel, title,  
	                					  JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
