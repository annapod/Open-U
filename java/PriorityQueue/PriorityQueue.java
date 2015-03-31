import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class PriorityQueue <T extends Comparable <T>>
{
	private ArrayList <T> elements;
	
	public PriorityQueue()
	{
		elements = new ArrayList <T>();
	}
	//constructor creates new queue
	public PriorityQueue(ArrayList <T> arr)
	{
		Collections.sort(arr);
		elements = new ArrayList <T>();
		elements.addAll(arr);
	}
	
	//add new element of type T and sort queue again
	public void add(T element)
	{
		elements.add(element);
		Collections.sort(elements);
	}
	
	//remove and return first item in the queue, throws empty queue exception
	public T poll () throws EmptyQueueException
	{
		T temp = null;
		
		if (this.isEmpty())
			throw new EmptyQueueException("Empty Queue");
		
		temp = elements.get(0);
		elements.remove(0);
		return temp;
	}
	//check if element is in queue
	public boolean contains(T element)
	{
		return elements.contains(element);
	}
	//remove element from the queue
	public boolean remove (T element)
	{	
			return elements.remove(element);
	}
	
	//check if queue is empty
	private boolean isEmpty()
	{
		return elements.isEmpty();
	}
	//num of elements in the queue
	public int size()
	{
		return elements.size();
	}
	//return iterator
	public Iterator<T> iterator()
	{
		return elements.iterator();
	}
	@Override
	public String toString()
	{
		String str = new String ("");
		for (int i = 0; i<this.size(); i++){
			str+=elements.get(i).toString()+"\n";
		}
		return str;
		
	}
}
