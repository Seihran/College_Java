import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		int backlog = 10;
		int port = 4400;
		Socket sock;
		
		ServerSocket serverSock = new ServerSocket(port, backlog);
		ExecutorService tpes =
			    Executors.newFixedThreadPool(backlog);
		
		while(true)
		{
			sock = serverSock.accept();
			
			ThreadHandler thread = new ThreadHandler(sock);
			
			tpes.execute(thread);

		    sock.close();
		}
	}
}