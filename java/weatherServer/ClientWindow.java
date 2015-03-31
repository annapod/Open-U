/**
 * Anna Podolny 322152893
 */
package weatherServer;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

/**
 * @author apodolny
 *
 */
public class ClientWindow extends JFrame implements ActionListener{

	private JPanel north;
	private JPanel south;
	private JButton go;
	private JButton update;
	private JComboBox<String> cities;
	private JTextArea result;
	private String server;
	private ServerConnector connector;
	
	public ClientWindow(){
		
		super("Weather App");
		north = new JPanel();
		south = new JPanel();
		go = new JButton("Go");
		update = new JButton("Update");
		result = new JTextArea(10,15);
		cities = new JComboBox<String>();
		
		
		result.setEditable(false);
		go.addActionListener(this);
		update.addActionListener(this);
		north.add(cities);
		north.add(go);
		north.add(update);
		add(north,BorderLayout.NORTH);
		south.add(result);
		add(south, BorderLayout.SOUTH);
	
		setSize(230,250);
		setResizable(false);
		server = JOptionPane.showInputDialog("Please enter weather server address: ");
		connector = new ServerConnector(server);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public String getServer(){
		return server;
	}
	
	public void setResult(String s){
		result.setText(s);
	}
	
	public void loadCities(ArrayList<String> s){
		for (int i = 0; i< s.size(); i++)
			cities.addItem(s.get(i));
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == update){
			
			loadCities(connector.update());
			
		}else if (e.getSource() == go){
			String cityIndex = cities.getSelectedItem().toString();
			connector.checkWeather(cityIndex);
		}
	}
	
	private class ServerConnector {
		
		DatagramSocket socket = null;
		byte[] buf;
		int port = 8888;
		String host;
		InetAddress address;
		

		public ServerConnector(String h)
		{
			try {
				this.socket = new DatagramSocket();
				this.buf = new byte[256];
				this.host = h;
	            this.address = InetAddress.getByName(host);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e){
				System.out.println("Server cannot be found");
				System.exit(1);
			}
		}
		
		public ArrayList <String> update(){
			ArrayList<String> result = new ArrayList<String>();
			String data = null;
			DatagramPacket packet;
			String command = "Update";
            buf = command.getBytes();
            
            packet = new DatagramPacket(buf, buf.length, address, port);
            try {
				socket.send(packet);
				byte[] res = new byte[256];
				packet = new DatagramPacket(res, res.length);
	            socket.receive(packet);
	            data = new String(packet.getData(), 0, packet.getLength());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            result.addAll(Arrays.asList(data.split(",")));
            
            return result;
		}
		
		public void checkWeather(String city){
			String data = null;
			DatagramPacket packet;
            buf = city.getBytes();
            
            packet = new DatagramPacket(buf, buf.length, address, port);
            try {
				socket.send(packet);
				byte[] res = new byte[256];
				packet = new DatagramPacket(res, res.length);
	            socket.receive(packet);
	            data = new String(packet.getData(), 0, packet.getLength());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            setResult("");
            setResult(data);
            
			
		}
		
		
			
	}
}


