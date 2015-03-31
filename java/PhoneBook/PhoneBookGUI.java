

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */

public class PhoneBookGUI extends JFrame{

	private static final int width = 650;
	private static final int heigh = 500;
	
	private JPanel window;
	private JPanel textPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JTextArea textArea;
	private JButton addButton;
	private JButton removeButton;
	private JButton updateButton;
	private JButton findButton;
	private BorderLayout layout;
	
	public PhoneBookGUI()
	{
		super("Phone Book");
		
		window = new JPanel();
		textPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panelLeft = new JPanel();
		panelRight = new JPanel();
		
		layout = new BorderLayout(5,5);
		String demoText = "demo text\n";
		textArea = new JTextArea(demoText,20,50);
		addButton = new JButton ("Add New Entry");
		removeButton = new JButton("Remove Entry");
		updateButton = new JButton("Update Entry");
		findButton = new JButton("Find Entry");
		addButton.setPreferredSize(new Dimension(120,25));
		removeButton.setPreferredSize(new Dimension(120,25));
		updateButton.setPreferredSize(new Dimension(120,25));
		findButton.setPreferredSize(new Dimension(120,25));
		
		window.setLayout(layout);
		window.add(textPanel,BorderLayout.NORTH);
		textPanel.add(new JScrollPane(textArea));
		
		panel1.add(addButton);
		panel2.add(removeButton);
		panelLeft.add(panel1);
		panelLeft.add(panel2);
		window.add(panelLeft,BorderLayout.WEST);
		
		panel3.add(updateButton);
		panel4.add(findButton);
		panelRight.add(panel3);
		panelRight.add(panel4);
		window.add(panelRight,BorderLayout.EAST);
		
		
		setSize(width,heigh);
		add(window);
		
		setVisible(true);
	}
	//add text to the textbox
	public void displayText(String txt)
	{
		this.textArea.setText(txt);
	}
	//add listeners to the buttons
	public void addAddListener(ActionListener add)
	{
        addButton.addActionListener(add);
    }
	
	public void addRemoveListener(ActionListener rm)
	{
        removeButton.addActionListener(rm);
    }
	
	public void addUpdateListener(ActionListener up)
	{
        updateButton.addActionListener(up);
    }
	
	public void addFindListener(ActionListener f)
	{
        findButton.addActionListener(f);
    }

	//show input dialog
	public String showDialog(String msg)
	{
		return JOptionPane.showInputDialog(msg);
	}
	//show error dialog
	public void showError(String err)
	{
		JOptionPane.showMessageDialog(null, err, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	//show info
	public void showInfo(String info)
	{
		JOptionPane.showMessageDialog(null, "Phone number is: "+info);
	}
}
