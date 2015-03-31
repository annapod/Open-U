/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class Person implements Comparable<Person>{
	
	private String name;
	private int bYear;
	
	public Person()
	{
		super();
		name = "";
		bYear = 0;
	}
	
	public Person(String n, int y)
	{
		super();
		name = n;
		bYear = y;
	}
	
	@Override
	public String toString()
	{
		return "My name is "+name+" ,I was born in "+bYear;
	}
	//Compare by year of birth
	@Override
	public int compareTo(Person p)
	{
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if (p.bYear > this.bYear)
	    	return BEFORE;
	    if (p.bYear < this.bYear)
	    	return AFTER;
	    return EQUAL;
	}

}
