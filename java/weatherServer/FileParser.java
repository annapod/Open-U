/**
 * Anna Podolny 322152893
 */
package weatherServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author apodolny
 *
 */
public class FileParser {
	
	private String filePath;
	private Map <String,String> index;
	private Scanner input;
	
	public FileParser(String p){
		this.filePath = p;
		index = new HashMap<String,String>();
	}

	//read from file
	public void readFromFile() throws FileNotFoundException
	{
		try
		{	
			//int line = 1;
			String key = "";
			String value = "";
			input = new Scanner (new File(filePath));
			while (input.hasNext())
			{
				key = input.nextLine();
				value = "";
				for (int i = 0; i<3; i++){
					value = value + input.nextLine()+"\n";
				}
				index.put(key, value);
			}
				//System.out.println(index.toString());
				
		}
		catch (FileNotFoundException e)
		{
			throw new FileNotFoundException();
		}
		finally
		{
			if (input != null)
				input.close();
		}
	}
	
	public String getCities(){
		String cities = "";
		String[] keys = index.keySet().toArray(new String[0]);
		for (int i = 0; i<keys.length; i++){
			cities = cities + keys[i] +",";
		}
		return cities;
	}
	
	public String getWeather(String city){
		String weather = "";
		weather = index.get(city);
		System.out.println(weather);
		return weather;
	}
}
