/**
 * Anna Podolny 322152893
 */
package weatherServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author apodolny
 *
 */
public class WeatherServer {

	 public static void main(String[] args)
	    {
		 boolean listening = true;
		 FileParser file = new FileParser("src\\weather_data");
		 DatagramSocket socket = null;
		 try {
			 file.readFromFile();
		 }
		 catch (FileNotFoundException e){
			 System.out.println("File not found, cannot start server!");
			 System.exit(1);
		 }
	        try{
	            socket = new DatagramSocket(8888);
	            System.out.println("Server's Ready");
	            byte[] buf = new byte[256];
	            while(listening){
	            	DatagramPacket packet = new DatagramPacket(buf, buf.length);
	            	socket.receive(packet);
	            	String data = new String(packet.getData(), 0, packet.getLength());
	            	System.out.println("DEBUG: "+data);
	            	if (data.equals("Update")){
	            		System.out.println("Got request to update");
	            		try {
	            			file.readFromFile();
	            			String response = file.getCities();
	            			System.out.println(response);
		            		buf = response.getBytes();
		    	            InetAddress address = packet.getAddress();
		    	            int port = packet.getPort();
		    	            packet = new DatagramPacket(buf, buf.length, address, port);
		    	            socket.send(packet);
	            		}
	            		catch (FileNotFoundException e){
	            			System.out.println("File not found, cannot start server!");
	            			System.exit(1);
	            		}
	            	}
	            	else{
	            		String response = file.getWeather(data);
	            		buf = response.getBytes();
	    	            InetAddress address = packet.getAddress();
	    	            int port = packet.getPort();
	    	            packet = new DatagramPacket(buf, buf.length, address, port);
	    	            socket.send(packet);
	            	}
	            
	            }
	        }
	        catch(IOException e){
	        	e.printStackTrace();
	        }
	        finally{
	        	socket.close();
	        }

	    }
}
