/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (10/12/2020)
 * 
*/

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class ClientHandler implements Runnable
{
	private Socket sock;
	//Create string arrays of countries and their capitals
	private String[] countries = {"Ireland", "England", "France","Spain",
								  "Germany", "Greece", "Sweden", "Russia"};
	private String[] capitals = {"Dublin", "London", "Paris", "Madrid",
								 "Berlin", "Athens", "Stockholm", "Moscow"};
	
	public ClientHandler(Socket sock)
	{
		this.sock = sock;
	}
	
	@Override
	public void run()
	{
		try
		{
			//Ask client for specified country
			String query = "What country's capital are you looking for?";

	        //Get I/O streams from the socket
	        PrintStream out = new PrintStream(sock.getOutputStream());
	        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

	        //Send quetion to client
	        out.println(query);
	        out.flush();

	        //Receive response
	        String reply = in.readLine();
	        
	        //Check that the country sent by the client is in the array
	        if(Arrays.asList(countries).contains(reply))
        	{
	        	//If it was, iterate through array and return the capital of that country
	        	for (int i=0; i<countries.length; i++)
		        {
	        		if(reply.contains(countries[i]))
		        	{
		        		out.println(capitals[i]);
		        		break;
		        	}
		        }
        	}
	        //If not, reply that the country is unknown
        	else
        	{
        		out.println("I don't know that country.");
        	}
	        //Close this connection
	        sock.close();
	    }
	    catch (IOException ex)
	    {
	    	System.out.println("Some error occured!");
	        ex.printStackTrace();
	    }
	}
}
