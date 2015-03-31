/**
 * Anna Podolny 322152893
 */
package chat;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author apodolny
 *
 */
public class ClientGUI extends JFrame implements ActionListener{

	

    private final String server = "localhost";
    private final int port = 8888;
    
	private JButton connect;
	private JButton disconnect;
	private JButton send;
	private JTextArea input;
	private JTextArea output;
	private JPanel north;
	private JPanel center;
	private JPanel south;
	private JScrollPane scrollIn;
	private JScrollPane scrollOut;
	private ChatClient clientWorker;
	private JLabel inLabel;
	private JLabel outLabel;
	
	public ClientGUI(){
		super("APC Chat");
		
		connect = new JButton("Connect");
		disconnect = new JButton("Disconnect");
		send = new JButton("Send");
		input = new JTextArea(10,20);
		output = new JTextArea(10,20);
		scrollIn = new JScrollPane(input);
		scrollOut = new JScrollPane(output);
		inLabel = new JLabel("Input:   ");
		outLabel = new JLabel("Output:");
		
		north = new JPanel();
		north.add(connect);
		connect.addActionListener(this);
		north.add(disconnect);
		disconnect.addActionListener(this);
		add(north,BorderLayout.NORTH);
		
		center = new JPanel();
		center.add(inLabel);
		center.add(scrollIn);
		center.add(outLabel);
		center.add(scrollOut);
		add(center,BorderLayout.CENTER);
		
		south = new JPanel();
		south.add(send);
		send.addActionListener(this);
		add(south,BorderLayout.SOUTH);
		
		setSize(300,480);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void writeLine (String msg){
		output.setText("");
		output.setText(msg);
	}
	
	public String readLine (){
		return input.getText();
	}
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == connect){
			clientWorker = new ChatClient(server, port,this);
			clientWorker.connectToServer();
			connect.setEnabled(false);
			
		}
		else if (e.getSource() == disconnect){
			if (clientWorker != null) {
				clientWorker.disconnectFromServer();
				connect.setEnabled(true);
			}
			
		}
		else if (e.getSource() == send){
			if ((clientWorker != null) && (!readLine().equals(""))){
				clientWorker.sendToServer(readLine());
			}
		}
		
	}
		
		

}
