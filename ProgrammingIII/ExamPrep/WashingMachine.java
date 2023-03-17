import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class WashingMachine extends JFrame implements ActionListener
{
	private JPanel controls = new JPanel();
	private Container container;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private String[] temps = {"20", "30", "40", "50", "60"};
	private ArrayList<JComponent> status = new ArrayList<JComponent>();
	private JComboBox<String> tempList = new JComboBox<String>(temps);
	JTextArea powerStatus = new JTextArea("Off");
    JTextArea speedStatus = new JTextArea("Not set");
    JTextArea tempStatus = new JTextArea("Not set");
	
	public WashingMachine()
	{
		super("Control Panel");
        container = getContentPane();
        layout = new GridBagLayout();
        container.setLayout(layout);
        constraints = new GridBagConstraints();
        tempList.addActionListener(this);
        
        Box boxP = Box.createVerticalBox();
		boxP.add(powerStatus);
		JPanel panelP = new JPanel();
		panelP.add(boxP);
		status.add(panelP);
		Box boxS = Box.createVerticalBox();
		boxS.add(speedStatus);
		JPanel panelS = new JPanel();
		panelS.add(boxS);
		status.add(panelS);
		Box boxT = Box.createVerticalBox();
		boxT.add(tempStatus);
		JPanel panelT = new JPanel();
		panelT.add(boxT);
		status.add(panelT);
        
        JButton power = new JButton("Power");
        power.addActionListener(this);
        JButton speed600 = new JButton("600 RPM");
        speed600.addActionListener(this);
        JButton speed800 = new JButton("800 RPM");
        speed800.addActionListener(this);
        JButton speed1200 = new JButton("1200 RPM");
        speed1200.addActionListener(this);
        
        addComponent(tempList, 0, 1, 1, 1);
        constraints.insets = new Insets(1, 80, 1, 1);
        addComponent(power, 1, 1, 1, 1);
        addComponent(speed600, 3, 0, 1, 1);
        constraints.insets = new Insets(1, 100, 1, 100);
        addComponent(speed800, 3, 1, 1, 1);
        constraints.insets = new Insets(1, 1, 1, 80);
        addComponent(speed1200, 3, 2, 1, 1);
        
        createStatus();
        
        setVisible(true);
	}
	
	public void createStatus()
	{
		JPanel panel = new JPanel(new GridLayout(0, 2));
		for (int i=0; i<status.size(); i++)
		{
			panel.add(status.get(i));
		}
		
        addComponent(panel, 1, 1, 1, 1);
	}
	
	public static void main(String[] args)
	{
		WashingMachine frame = new WashingMachine();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addComponent(Component component,
			int row, int column, int width, int height)
	{
		constraints.gridx = column;
		constraints.gridy = row;

		constraints.gridwidth = width;
		constraints.gridheight = height;

		layout.setConstraints(component, constraints);
		container.add(component);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "Power")
		{
			System.out.println("Power on.");
			powerStatus.replaceRange("On", 0, 3);
			createStatus();
			
		}
		else if (e.getActionCommand() == "600 RPM")
		{
			System.out.println("Speed set to 600.");
			speedStatus.replaceRange("600 RPM", 0, 7);
			createStatus();
		}
		else if (e.getActionCommand() == "800 RPM")
		{
			System.out.println("Speed set to 800.");
			speedStatus.replaceRange("800 RPM", 0, 7);
			createStatus();
		}
		else if (e.getActionCommand() == "1200 RPM")
		{
			System.out.println("Speed set to 1200.");
			speedStatus.replaceRange("1200 RPM", 0, 7);
			createStatus();
		}
		else if (e.getActionCommand() == "comboBoxChanged")
		{
			JComboBox<?> combo = (JComboBox<?>)e.getSource();
			if (combo.getSelectedIndex() == 0)
			{
				System.out.println("Temperature set to 20.");
				tempStatus.replaceRange("Temp 20", 0, 7);
				createStatus();
			}
			else if (combo.getSelectedIndex() == 1)
			{
				System.out.println("Temperature set to 30.");
				tempStatus.replaceRange("Temp 30", 0, 7);
				createStatus();
			}
			else if (combo.getSelectedIndex() == 2)
			{
				System.out.println("Temperature set to 40.");
				tempStatus.replaceRange("Temp 40", 0, 7);
				createStatus();
			}
			else if (combo.getSelectedIndex() == 3)
			{
				System.out.println("Temperature set to 50.");
				tempStatus.replaceRange("Temp 50", 0, 7);
				createStatus();
			}
			else
			{
				System.out.println("Temperature set to 60.");
				tempStatus.replaceRange("Temp 60", 0, 7);
				createStatus();
			}
		}
	}
}
