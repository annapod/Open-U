/**
 * Anna Podolny 322152893
 */
package chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * @author apodolny
 *
 */
public class ChatServer {


    private static ArrayList <ClientListener> clients;
    
    public static void main(String[] args)
    {
        ServerSocket srv = null;
        int numOfClients = 0;
        boolean listening = true;
        clients = new ArrayList<ClientListener>();
        try {
            srv = new ServerSocket(8888);
            System.out.println("Server's ready");
            
            while(listening){
            	Socket socket = srv.accept();
            	ClientListener c = new ClientListener(socket);
            	clients.add(c);
            	numOfClients++;
            	System.out.println("Client "+numOfClients+" connected.");
            	if (numOfClients % 2 == 0){
            		startChat(clients.get(clients.size()-2),clients.get(clients.size()-1));
            	}
            }
           
        }
        catch(InterruptedIOException e)
        {
            System.out.println("Time out");
        }
        catch(IOException e)
        { 
            e.printStackTrace(); 
            System.exit(1);
        }
        
        
        
    }
    public static void startChat(ClientListener c1, ClientListener c2){
    	System.out.println("Start chat");
    	c1.setPeer(c2);
    	c2.setPeer(c1);
    	c1.start();
    	c2.start();
    }
    
   
    
    
}
