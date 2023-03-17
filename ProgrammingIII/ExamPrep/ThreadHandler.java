import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadHandler implements Runnable
{
	private String response = "Question?";
	private Socket sock;
	
	public ThreadHandler(Socket sock)
	{
		this.sock = sock;
	}
	
	public void run()
	{
		try
		{
			PrintStream out = new PrintStream(sock.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

			String query = in.readLine();
			
			out.println(response);
			out.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
};