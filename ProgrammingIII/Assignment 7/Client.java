/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (10/12/2020)
 * 
*/

import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String[] args) throws IOException
	{
		Socket sock;
		
		//String response if no arguments are given
		String country = "Unknown";
		//Default server
		String server = "localhost";
		//Default port, any available one
		int port = 0;
		
		//If arguments are passed in
		//Assign given string, server and port to variables
	    if (args.length > 0)
	    {
	    	country = args[0];
	    	server = args[1];
	    	port = Integer.valueOf(args[2]);
	    }

	    //Create socket with default or given details
	    sock = new Socket(server, port);
	    
	    //Create input and output streams
	    BufferedReader in = new BufferedReader(
	    		            new InputStreamReader(
	    		            sock.getInputStream()));
	    PrintStream out = new PrintStream(sock.getOutputStream() );

	    //Read in from server
	    String fromServer = in.readLine();

	    //Display what was received
	    System.out.println("Got this from server: " + 		fromServer);
	    
	    //Send country query
	    out.println(country);
	    out.flush();
	    
	    //Display response from server
	    fromServer = in.readLine();
	    System.out.println("Got this from server: " + 		fromServer);
	    
	    //Close socket upon completion
	    sock.close();
	}
}
