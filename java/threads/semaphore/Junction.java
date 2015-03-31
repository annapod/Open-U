import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class Junction extends Thread{

	SemaphoreGUI gui;
	private ArrayList <Semaphore> semaphores;
	private Timer timer;
	private Boolean state;
	
	public Junction(int num)
	{	
		gui = new SemaphoreGUI();
		semaphores = new ArrayList <Semaphore>(num);
		gui.addSemaphores(semaphores);
		state = true;
		//timer: on each tic semaphore state changed from cars to pedestrians and all semaphores repainted
		timer = new Timer(1500, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  state = !state;
		    	  flop(state);
		    	  repaint();
		      }
		     });

	}
	
	public void run()
	{
		
		timer.start();
					
	}
	//repaint all semaphores
	public void repaint()
	{
		for (int i = 0; i<semaphores.size(); i++)
		{
			semaphores.get(i).repaint();
		}
	}
	
	//change semaphore status from cars to pedestrian and vice versa
	public void flop(Boolean x)
	{
		semaphores.get(0).setIfCars(!x);
		semaphores.get(1).setIfCars(x);
		semaphores.get(2).setIfCars(x);
		semaphores.get(3).setIfCars(!x);

	
	}
}
