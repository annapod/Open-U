import java.util.ArrayList;

/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class TestInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ArrayList <Integer> intq = new ArrayList<Integer>();
		intq.add(5);
		intq.add(55);
		intq.add(905);
		intq.add(0);
		intq.add(25);
		intq.add(27);
		
		//create new queue
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(intq);
		
		//check toString and new queue creation
		System.out.println("After sorting");
		System.out.println(q.toString());
		//test remove
		q.remove(55);
		System.out.println("After remove");
		System.out.println(q.toString());
		//test poll
		try {
			System.out.println("Poll first element: "+q.poll());
			System.out.println("Poll element: "+q.poll());
			System.out.println("Poll element: "+q.poll());
			System.out.println("Poll element: "+q.poll());
			System.out.println("Poll element: "+q.poll());
			//test exception
			System.out.println("test exception, queue should be empty.");
			System.out.println("Poll element: "+q.poll());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After poll");
		System.out.println(q.toString());
		
		//test add
		q.add(9);
		System.out.println("After add");
		System.out.println(q.toString());
		
	}

}
