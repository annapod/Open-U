/**
 * Anna Podolny 322152893
 */
package matrix;

/**
 * @author apodolny
 *
 */
import java.util.Random;
public class Matrix {
	
	private int rows; 
	private int cols;
	public int matrix[][];
	
	
	public Matrix (int x, int y)
	{
		rows = x;
		cols = y;
		matrix = createMatrix(rows,cols);
	}
	//create matrix with random values
	private int[][] createMatrix (int row, int col)
	{
		int [][] M = new int [row][col];
		Random rand = new Random();
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				M[i][j] = rand.nextInt(10);
		return M;
	}
	//initiate matrix with zeros
	private void initMatrix (int row, int col)
	{
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix[i][j] = 0;
	
	}
	//Multiply 2 matrices using thread for each cell
	public Matrix multiply (Matrix M)
	{
		int new_row, new_col, numOfThreads;
		new_row = rows;
		new_col = M.getCols();
		numOfThreads = new_row * new_col;
		int threadsCount = 0;
        MultiplyThread[] threads = new MultiplyThread[numOfThreads];// = new Thread[numOfThreads];
        MultiplyThread prev;
		Matrix res = new Matrix (new_row, new_col);
		res.initMatrix(new_row, new_col);
		if (this.cols != M.getRows())
		{
			System.out.println("Cannot multiply: number of colums of 1st matrix should be same as number of rows in 2nd matrix!");
			System.exit(1);
			
		}
		//System.out.println("Num of threads: "+numOfThreads);
        for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < M.getCols(); j++) {
		    	//assign previous thread reference for new thread
		    	if (threadsCount == 0)
		    	{
		    		prev = new MultiplyThread();
		    	}
		    	else
		    	{
		    		prev = threads[threadsCount - 1];
		    	}
		    	//System.out.println("Start thread number "+threadsCount);
		        // creating thread for multiplications
		        threads[threadsCount] = new MultiplyThread(i, j, this, M, res, threadsCount,prev);
		        threads[threadsCount].start(); //thread start
		        threadsCount++;
		    }
		}
		
		return res;
	}
	
	
	
	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * @param cols the cols to set
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}

	public String toString ()
	{
		String str = new String ();
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) 
                str += "  " + matrix[i][j];
            str+="\n";
        }
		return str;
	}

}
