/**
 * Anna Podolny 322152893
 */
package chat;

import java.io.*;
import java.net.*;

/**
 * @author apodolny
 *
 */
public class ChatClient {

    private Socket socket = null;
    private PrintWriter out;
    private BufferedReader in;
    private String server;
    private int port;
    private ClientGUI client;
    private boolean connected = false;
   
    public ChatClient(String host, int p, ClientGUI client) {
    	
    	this.client = client;
        this.server = host;
        this.port = p;

    }
    
    public void connectToServer(){
    	
    	try {
    		socket = new Socket (server,port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			connected = true;
			new ServerListener().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public void disconnectFromServer(){
    	
    	connected = false;
    	out.println("#disconnect");
    	
    }
    
    public void sendToServer(String s){
    	out.println(s);
    }
    
    private class ServerListener extends Thread{
    	
    	public void run()
        {
        	
            String input;
            try {
            	
                input = in.readLine();
                while(connected)
                {
                                    
                    client.writeLine(input);
                    input = in.readLine();
                }
                in.close();
                out.close();
                socket.close();
             }
             catch(IOException e) { 
            	 e.printStackTrace();
             }
        }
    }
    
    
}
