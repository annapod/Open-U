/**
 * Anna Podolny 322152893
 */
package matrix;

/**
 * @author apodolny
 *
 */
public class MultiplyThread extends Thread{
	
	private int x;
	private int y;
	private int res;
	private Matrix MatrixA; //first input matrix
    private Matrix MatrixB; //second input matrix
    private Matrix MatrixC; //result matrix
    private int counter;
    private boolean isDone;
    private MultiplyThread previous;


	public MultiplyThread(int x, int y, Matrix m1, Matrix m2, Matrix m3, int c, MultiplyThread t)
	{
		super();
		this.x = x;
		this.y = y;
		this.res = 0;
		this.MatrixA = m1;
		this.MatrixB = m2;
		this.MatrixC = m3;
		this.counter = c;
		this.isDone = false;
		this.previous = t;
	}
	
	//default constructor
	public MultiplyThread()
	{
		super();
		this.x = 0;
		this.y = 0;
		this.res = 0;
		this.MatrixA = new Matrix(0,0);
		this.MatrixB = new Matrix(0,0);
		this.MatrixC = new Matrix(0,0);
		this.counter = 0;
		this.isDone = false;
		this.previous = this;
	}
	
	public void run()
	{
		for (int i = 0; i < MatrixA.getRows(); i++) //calc result
		{
			res += MatrixA.matrix[x][i] * MatrixB.matrix[i][y];
			
		}
		MatrixC.matrix[x][y] = res;
		waitForPrint();//wait for previous thread to finish calculation and print the result
		
	}
	//Print the result and notify when it's done
	public synchronized void printed()
	{
		
		//System.out.println("Thead number: "+counter+ " has finished, result is: "+res);
		System.out.print(res+" ");
		if (y == MatrixB.getRows()){
			System.out.println("\n");
		}
		setIsDone(true);
		notify();
	}

	public synchronized void waitForPrint ()
	{
		if (counter == 0)//is first thread, no need to wait
		{
			printed();
			return;
			
		}
		else
		{
			synchronized (previous){
				//wait until previous will finish print
				while (!previous.getIsDone())//isDone == false
				{
					try {
						//System.out.println("DEBUG: I'm "+counter+", waiting for "+previous.getCounter()+" "+previous.getIsDone());
						previous.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				printed();
				return;
			}
		}
	}

	/**
	 * @return the _res
	 */
	public int getRes() {
		return res;
	}

    
	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @return the isDone
	 */
	public boolean getIsDone() {
		return isDone;
	}

	/**
	 * @param b the isDone to set
	 */
	public void setIsDone(boolean b) {
		this.isDone = b;
	}
}
