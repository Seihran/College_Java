/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (06/11/2020)
 * 
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame implements ActionListener, MouseListener
{
	private static final long serialVersionUID = 2535412714448623429L;
	//Declaration of variables
	private JPanel picture = new JPanel();
	private JPanel pictures = new JPanel();
	private int picNum = 0;
	private Icon icon;
	//Names for slide shows
	private String[] items = {"Animals", "Flowers", "Food"};
	private JComboBox<String> itemList = new JComboBox<String>(items);
	private Container container;
	//Classes for actions of keybinding
	private Next next = new Next();
    private Previous prev = new Previous();
    //Obtain dimensions of default monitor being used
    private GraphicsDevice gd = GraphicsEnvironment
    		                    .getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private int width = gd.getDisplayMode().getWidth();
    private int height = gd.getDisplayMode().getHeight();  
    //Sets slider dimensions to be 1/5 of the current max screen resolution
	private JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 1, width/5, height/5);
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	//Array of colours for backgrounds
	private Color colourValues[] = {Color.black, Color.blue, Color.red, Color.green};
	private int counter = 0;
	//Array to remember background colours between slide shows
	private int[] colourFlag = {0, 0, 0};

	public GUI()
	{
        super("Slide Shows");
        //Creates container and layout
        container = getContentPane();
        layout = new GridBagLayout();
        container.setLayout(layout);
        constraints = new GridBagConstraints();
        //Adds listeners to pick up combobox and mouse
        itemList.addActionListener(this);
        picture.addMouseListener(this);
        
        //Adds first default image
        pictures.add(addImage(items[0] + 0));
        picture.add(pictures);
        
        //Creates keybinding of next and previous for slide show
        picture.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW)
        		.put(KeyStroke.getKeyStroke('n'), "next");
        picture.getActionMap().put("next", next);
        picture.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW)
        		.put(KeyStroke.getKeyStroke('p'), "previous");
        picture.getActionMap().put("previous", prev);
        
        //Anonymous inner class to deal with slider movement
        slider.addChangeListener(new ChangeListener()
        {
        	// handle change in slider value
        	public void stateChanged(ChangeEvent e)
        	{
        		changeImage();
            }

        });  // end anonymous inner class
        
        //Creates buttons for background colours and attaches event listener
        JButton animalColour = new JButton("Animal Background Colour");
        animalColour.addActionListener(this);
        JButton flowerColour = new JButton("Flower Background Colour");
        flowerColour.addActionListener(this);
        JButton foodColour = new JButton("Food Background Colour");
        foodColour.addActionListener(this);
        
        //Adds each component to grid layout
        addComponent(itemList, 0, 1, 1, 1);
        constraints.weightx = 1;  // can grow wider
        constraints.weighty = 1;     // can grow taller
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(picture, 1, 1, 1, 1);
        //Resets weights to 0
        constraints.weightx = 0;
        constraints.weighty = 0;
        addComponent(slider, 2, 1, 1, 1);
        //Spaces out buttons
        constraints.insets = new Insets(1, 80, 1, 1);
        addComponent(animalColour, 3, 0, 1, 1);
        constraints.insets = new Insets(1, 100, 1, 100);
        addComponent(flowerColour, 3, 1, 1, 1);
        constraints.insets = new Insets(1, 1, 1, 80);
        addComponent(foodColour, 3, 2, 1, 1);
         
        //Sets window size based on current default screen resolution
        setSize(width/2, height/2);
        setVisible(true);
	}
	
	private void addComponent(Component component,
			     int row, int column, int width, int height)
	{
		// set gridx and gridy
	    constraints.gridx = column;
	    constraints.gridy = row;

	    // set gridwidth and gridheight
	    constraints.gridwidth = width;
	    constraints.gridheight = height;

	    // set constraints and add component
	    layout.setConstraints(component, constraints);
	    container.add(component);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//If the event is one of the buttons, checks if statement for specific one
		if (e.getActionCommand() == "Animal Background Colour")
		{
			//Only changes background if current slide show matches button
			if (itemList.getSelectedIndex() == 0)
			{
				//Sets colour to next in array based on counter value
				picture.getComponent(0)
				       .setBackground(colourValues[counter]);
				picture.setBackground(colourValues[counter]);
				getContentPane().setBackground(colourValues[counter]);
				//Stores counter value for next time this slide show is selected
				colourFlag[0] = counter;
				counter++;
			}
		}
		else if (e.getActionCommand() == "Flower Background Colour")
		{
			if (itemList.getSelectedIndex() == 1)
			{
				picture.getComponent(0)
			           .setBackground(colourValues[counter]);
				picture.setBackground(colourValues[counter]);
				getContentPane().setBackground(colourValues[counter]);
				colourFlag[1] = counter;
				counter++;
			}
		}
		else if (e.getActionCommand() == "Food Background Colour")
		{
			if (itemList.getSelectedIndex() == 2)
			{
				picture.getComponent(0)
			           .setBackground(colourValues[counter]);
				picture.setBackground(colourValues[counter]);
				getContentPane().setBackground(colourValues[counter]);
				colourFlag[2] = counter;
				counter++;
			}
		}
		//If event is combobox being selected
		else if (e.getActionCommand() == "comboBoxChanged")
		{
			//Casts the event to a combobox
			JComboBox<?> combo = (JComboBox<?>)e.getSource();
			//Checks which slide show was selected
			if (combo.getSelectedIndex() == 0)
			{
				//Sets global itemlist value to be this specific slide show
				itemList.setSelectedIndex(0);
				picNum = 0;
				//Changes image
				changeImage();
				//Calls the stored colour value and changes to it
				counter = colourFlag[0] + 1;
				picture.getComponent(0)
		               .setBackground(colourValues[colourFlag[0]]);
				picture.setBackground(colourValues[colourFlag[0]]);
				getContentPane().setBackground(colourValues[colourFlag[0]]);
			}
			else if (combo.getSelectedIndex() == 1)
			{
				itemList.setSelectedIndex(1);
				picNum = 0;
				changeImage();
				counter = colourFlag[1] + 1;
				picture.getComponent(0)
	                   .setBackground(colourValues[colourFlag[1]]);
				picture.setBackground(colourValues[colourFlag[1]]);
				getContentPane().setBackground(colourValues[colourFlag[1]]);
			}
			else if (combo.getSelectedIndex() == 2)
			{
				itemList.setSelectedIndex(2);
				picNum = 0;
				changeImage();
				counter = colourFlag[2] + 1;
				picture.getComponent(0)
	                   .setBackground(colourValues[colourFlag[2]]);
				picture.setBackground(colourValues[colourFlag[2]]);
				getContentPane().setBackground(colourValues[colourFlag[2]]);
			}
		}
		//Resets counter to 0 if colour array limit is reached
		if (counter == colourValues.length)
		{
			counter = 0;
		}
	}
	
	private Component addImage(String name)
	{
		//Calls the fin image function with path name as incoming + jpg
		icon = findImage(name + ".jpg");
		//Assigns image to a label
		JLabel picture = new JLabel(icon);
        
		//Checks if image was found and prints message to replace if not
        if (icon != null)
        {
        	picture.setText(null);
        }
        else
        {
        	picture.setText("Image not found");
        }
        
        return picture;
	}
	
	public ImageIcon findImage(String path)
    {
		//Reads in an image as a bufferedimage as long as the path was valid
		BufferedImage pic = null;
        if (path != null)
        {
        	try
        	{
				pic = ImageIO.read(new File(path));
			}
        	catch (IOException e)
        	{
				e.printStackTrace();
			}
        	//Scales image to current value of the slider
        	return new ImageIcon(pic.getScaledInstance(
        			             slider.getValue(), slider.getValue(),
        			             Image.SCALE_FAST));
        }
        //Prints error if file wasn't found
        else
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	public void changeImage()
	{
		//Removes label from base label and current image from label
		picture.remove(pictures);
        pictures.removeAll();
        //Rereads image
        BufferedImage pic = null;
		try
		{
			pic = ImageIO.read(new File(items[itemList.getSelectedIndex()]
				  + picNum + ".jpg"));
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		//Scales and adds new image to label
		pictures.add(new JLabel(new ImageIcon(pic
			    .getScaledInstance(slider.getValue(), slider.getValue(),
			    Image.SCALE_FAST))));
		picture.add(pictures);
		setVisible(true);
	}
	
	public class Next extends AbstractAction
	{
		private static final long serialVersionUID = 7247311763331704577L;
		public Next()
        {
            super();
        }
        public void actionPerformed(ActionEvent e)
        {
        	next();
        }
        //Selects next image from stored files when called based on current slide show
        //Loops if last image
        public void next()
        {
        	if (itemList.getSelectedIndex() == 0)
			{
        		picNum++;
        		if (picNum == 3)
        		{
        			picNum = 0;
        		}
        		changeImage();
			}
			else if (itemList.getSelectedIndex() == 1)
			{
				picNum++;
        		if (picNum == 3)
        		{
        			picNum = 0;
        		}
        		changeImage();
			}
			else if (itemList.getSelectedIndex() == 2)
			{
				picNum++;
        		if (picNum == 3)
        		{
        			picNum = 0;
        		}
        		changeImage();
			}
        }
    }
	
	public class Previous extends AbstractAction
	{
		private static final long serialVersionUID = -7865381970988640772L;
		public Previous()
        {
            super();
        }
        public void actionPerformed(ActionEvent e)
        {
        	previous();
        }
        //Selects previous image from stored files when called based on current slide show
        //Loops if first image
        public void previous()
        {
        	if (itemList.getSelectedIndex() == 0)
			{
        		picNum--;
        		if (picNum < 0)
        		{
        			picNum = 2;
        		}
        		changeImage();
			}
			else if (itemList.getSelectedIndex() == 1)
			{
				picNum--;
        		if (picNum < 0)
        		{
        			picNum = 2;
        		}
        		changeImage();
			}
			else if (itemList.getSelectedIndex() == 2)
			{
				picNum--;
        		if (picNum < 0)
        		{
        			picNum = 2;
        		}
        		changeImage();
			}
        }
    }
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		//Detects left and right mouse clicks
		if (e.getButton() == 1)
		{
			next.next();
		}
		else if(e.getButton() == 3)
		{
			prev.previous();
		}
	}
	
	public static void main(String[] args)
	{
		//Calls an instant of this class and
		//sets program to shutdown when the GUI is closed
		GUI frame = new GUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Unused mouse events
	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}