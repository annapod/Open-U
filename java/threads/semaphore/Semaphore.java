import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class Semaphore extends JPanel{
	
	private int coordinateX;
	private int coordinateY;
	private Color drawColor;
	private int radius = 40;
	Color green = new Color (50,205,50);
	Color red = new Color (255,99,71);
	private boolean ifCars = false;
	private Dimension dim;
	
	/**
	 * @return the dim
	 */
	public Dimension getDim() {
		return dim;
	}

	/**
	 * @param dim the dim to set
	 */
	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	public Semaphore ()
	{
		super();
		coordinateX = 0;
		coordinateY = 0;
		drawColor = Color.BLACK;
		
	}
	
	public Semaphore (int x, int y)
	{
		super();
		coordinateX = x;
		coordinateY = y;
		drawColor = Color.BLACK;
		
	}
	//display semaphore depending on state
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if (ifCars)
		{
			g2.setColor(drawColor);
			g2.drawArc(coordinateX, coordinateY, radius, radius, 0, 360);
			g2.setColor(green);
			g2.fillArc(coordinateX, coordinateY+radius, radius, radius, 0, 360);
			g2.setColor(red);
			g2.fillRect(coordinateX+(radius/3+1), coordinateY+(radius*2), 10, 25);
			g2.setColor(drawColor);
			g2.drawRect(coordinateX+(radius/3+1), coordinateY+(radius*2)+25, 10, 25);
			
		}
		else{
			g2.setColor(red);
			g2.fillArc(coordinateX, coordinateY, radius, radius, 0, 360);
			g2.setColor(drawColor);
			g2.drawArc(coordinateX, coordinateY+radius, radius, radius, 0, 360);
			g2.drawRect(coordinateX+(radius/3+1), coordinateY+(radius*2), 10, 25);
			g2.setColor(green);
			g2.fillRect(coordinateX+(radius/3+1), coordinateY+(radius*2)+25, 10, 25);
		}
				
	}
	
	
	public void locateSemapore (int x, int y)
	{
		coordinateX = x;
		coordinateY = y;
	}
	/**
	 * @return the fillColor
	 */
	public Color getDrawColor() {
		return drawColor;
	}

	/**
	 * @param fillColor the fillColor to set
	 */
	public void setDrawColor(Color fillColor) {
		this.drawColor = fillColor;
	}

	/**
	 * @return the ifCars
	 */
	public boolean isIfCars() {
		return ifCars;
	}

	/**
	 * @param ifCars the ifCars to set
	 */
	public void setIfCars(boolean ifCars) {
		this.ifCars = ifCars;
	}

}
