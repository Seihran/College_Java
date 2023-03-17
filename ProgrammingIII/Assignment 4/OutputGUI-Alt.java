/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (06/11/2020)
 * 
 * Creates scrollable tabbed pane to display outputs from main class
*/

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class OutputGUI
{
	//Constructor takes in textAreas created in main Test class
	public OutputGUI(JTextArea textArea, JTextArea textArea1,
					 JTextArea textArea2, JTextArea textArea3)
	{
		//Creates tabbed pane
		JTabbedPane tabbedPane = new JTabbedPane();
		//Creates vertical boxes for each text area
		Box box = Box.createVerticalBox();
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		Box box3 = Box.createVerticalBox();
		box.add(textArea);
		box1.add(textArea1);
		box2.add(textArea2);
		box3.add(textArea3);
		//Creates panels for each box
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		//Adds boxes to panels
		panel.add(box);
		panel1.add(box1);
		panel2.add(box2);
		panel3.add(box3);
		//Creates scroll bars for each panel
		JScrollPane scroll = new JScrollPane(panel);
		JScrollPane scroll1 = new JScrollPane(panel1);
		JScrollPane scroll2 = new JScrollPane(panel2);
		JScrollPane scroll3 = new JScrollPane(panel3);
		//Sets size for each panel
		scroll.setPreferredSize(new Dimension(267, 400));
		scroll1.setPreferredSize(new Dimension(267, 400));
		scroll2.setPreferredSize(new Dimension(267, 400));
		scroll3.setPreferredSize(new Dimension(267, 400));
		//Adds panels to tabbed pane and establishes events
		//To change between tabs
		tabbedPane.addTab("Natural Order", scroll);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		tabbedPane.addTab("Cost: Descending", scroll1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		tabbedPane.addTab("Inv: Ascending", scroll2);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		tabbedPane.addTab("Binary Search and Map", scroll3);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		//Creates message dialogue pane with tabbed pane as component
		JOptionPane.showMessageDialog(null, tabbedPane, "Various Sorting Methods",  
                JOptionPane.INFORMATION_MESSAGE);
	}
}
