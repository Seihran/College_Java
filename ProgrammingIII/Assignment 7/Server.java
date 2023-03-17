/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (10/12/2020)
 * 
*/

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		//Create a queue size for pending connections
		int backlog = 10;
		//Specify a port
		int port = 4400;
		Socket sock;
		
		//Establish a server socket for allowing connections
		ServerSocket serverSock = new ServerSocket(port, backlog);
		//Creates an executor for running a fixed pool of threads
		ExecutorService tpes =
			    Executors.newFixedThreadPool(backlog);
		
		//Continuously run
		while(true)
		{
			//Wait for connections
			sock = serverSock.accept();
			
			//Create a thread to handle incoming client
			ClientHandler client = new ClientHandler(sock);
			//Run thread
			tpes.execute(client);
		}
	}
}
