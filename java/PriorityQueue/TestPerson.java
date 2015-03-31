import java.util.ArrayList;
import java.util.Iterator;
/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList <Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Person A",1980));
		persons.add(new Person("Person P",1983));
		persons.add(new Person("Person C",1986));
		persons.add(new Person("Person D",1975));
		
		
		System.out.println("After insert, but before sort");
		for (int i = 0; i<persons.size(); i++){
			System.out.println(persons.get(i).toString());
		}
		
		PriorityQueue<Person> q = new PriorityQueue<Person>(persons);
		//check toString and new queue creation
		System.out.println("After sorting");
		System.out.println(q.toString());
		//testing iterator
		System.out.println("Testing iterator");
		Iterator <Person> itr = q.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().toString());
		}
		System.out.println("Add new person");
		Person p = new Person ("Person B",1900);
		q.add(p);
		System.out.println("After add");
		System.out.println(q.toString());
		System.out.println("Remove person "+p.toString());
		System.out.println(q.remove(p));
		System.out.println("After remove");
		System.out.println(q.toString());
		try {
			System.out.println(q.poll().toString());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After poll");
		System.out.println(q.toString());
	
		
	}

}
