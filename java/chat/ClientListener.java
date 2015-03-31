/**
 * Anna Podolny 322152893
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 * @author apodolny
 *
 */
public class ClientListener extends Thread{

	private Socket socket;
	PrintWriter out = null;
	BufferedReader in = null;
	ClientListener peer = null;
	
	public ClientListener(Socket s){
		
		this.socket = s;
		try {
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	public void setPeer(ClientListener c){
		this.peer = c;
	}
	
	
	public void run(){
        String input;
        try {
            input = in.readLine();
            while(input != null)
            {
            	//System.out.println(input);
            	if (input.equals("#disconnect")){
            		
            		in.close();
                    out.close();
                    socket.close();
                    
                
            	}
            	else {
            		peer.out.println(input);
            		input = in.readLine();
            	}
                
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
