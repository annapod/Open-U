import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;

/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
public class PhoneBook {

	private Map <String,String> index;
	private String filePath = "src\\phone_book.txt";
	private Scanner input;
	private Formatter output;
	
	public PhoneBook()
	{
		index = new HashMap<String,String>();
		readFromFile(filePath, index);
	}
	
	//read from file
	private void readFromFile(String path, Map<String,String> map)
	{
		try
		{	
			//String s = new File(path).getAbsolutePath();
			//System.out.println(s);
			//File f = new File(path);
			input = new Scanner (new File(path));
			while (input.hasNext())
			{
				//System.out.println(input.nextLine());
				//System.out.println("name is: "+input.next());
				//System.out.println("phone is: "+input.next());
				map.put(input.next(), input.next());
			}
			//System.out.println(map.toString());
			//System.out.println(toString());
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Cannot find file: "+path);
			System.exit(1);
		}
		finally
		{
			if (input != null)
				input.close();
		}
		
	}

	//write map to a file
	public void writeToFile(String path, Map<String,String> map)
	{
		try
		{	
			//String s = new File(path).getAbsolutePath();
			//System.out.println(s);
			//File f = new File(path);
			output = new Formatter (new File(path));
			Set<String> keys = map.keySet();//get all keys
			
			for (String key : keys)
			{
				output.format("%s %s\n",key, map.get(key));
			}
			//System.out.println(map.toString());
			//System.out.println(toString());
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Cannot find file: "+path);
			System.exit(1);
		}
		finally
		{
			if (output != null)
				output.close();
		}
	}
	
	//check if string is contained of numeric values
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	//check if record is exists in the map (file)
	public boolean isExists(String key)
	{
		return index.containsKey(key);
	}
	
	//add record
	public void addRecord(String name, String phone)
	{
		//update map
		index.put(name, phone);
		
		//update file
		writeToFile(filePath,index);
	}
	//remove remove record from the map
	public void removeRecord(String key)
	{
		index.remove(key);
		//update file
		writeToFile(filePath,index);
	}
	//update record
	public void updateRecord(String key, String value)
	{
		index.replace(key, value);
		//update file
		writeToFile(filePath,index);
		
	}
	//find record
	public String findRecord(String key)
	{
		return index.get(key);
	}
	@Override
	//displays file's sorted file's content
	public String toString()
	{
		String allContent = new String("");
		
		Set <String> keys = index.keySet();
		//sort
		TreeSet<String> sortedKeys = new TreeSet<String>(keys);
		for (String key: sortedKeys)
			allContent+=key+"\t"+index.get(key)+"\n";
		return allContent;
	}
}
