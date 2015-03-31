/**
 * Anna Podolny 322152893
 */
package matrix;



/**
 * @author apodolny
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 4 ){
			System.out.println("Please enter 4 arguments, separated sy single space.");
		}
		//create matrices with random values
		Matrix A = new Matrix (Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		System.out.println(A.toString());
		Matrix B = new Matrix (Integer.parseInt(args[2]),Integer.parseInt(args[3]));
		System.out.println(B.toString());
		
		Matrix C;
		//multiply matrices
		C = A.multiply(B);
		//make sure all thread are finished
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Check:\n");
		System.out.println(C.toString());
	}



}
