import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
/*GUI Class: create main frame window and add all semaphores*/
public class SemaphoreGUI extends JFrame{

	private static final int width = 650;
	private static final int heigh = 600;
	
	
	public SemaphoreGUI()
	{
		super("Semaphores");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		setSize(width,heigh);
		setVisible(true);
		setResizable(false);
	}
	/*Create and locate semaphores in the main window*/
	public void addSemaphores (ArrayList<Semaphore> semaphores)
	{
		Semaphore s1 = new Semaphore();
		s1.setIfCars(true);
		s1.setPreferredSize(new Dimension(50,150));
		//s1.setBackground(Color.WHITE);
		semaphores.add(s1);
		
		Semaphore s2 = new Semaphore(90,0);
		s2.setPreferredSize(new Dimension(150,150));
		semaphores.add(s2);
		
		Semaphore s3 = new Semaphore(0, 0);
		s3.setPreferredSize(new Dimension(150,150));
		semaphores.add(s3);

		Semaphore s4 = new Semaphore(0,0);
		s4.setPreferredSize(new Dimension(50,150));
		s4.setIfCars(true);
		semaphores.add(s4);
	
		GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setLayout(new GridBagLayout());
        gbc.gridx = 200;
        gbc.gridy = 0;
        getContentPane().add(s1, gbc);
        gbc.gridx = 400;
        gbc.gridy = 1;
        getContentPane().add(s2, gbc);
        gbc.gridx = 10;
        gbc.gridy = 1;
        getContentPane().add(s3, gbc);
        gbc.gridx = 200;
        gbc.gridy = 2;
        getContentPane().add(s4, gbc);
       
		
	}
	
	
}
