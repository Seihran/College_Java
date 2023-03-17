
public class AccountTransactions implements Runnable
{
	private boolean shutdown = false;
	@Override
	public synchronized void run()
	{
		while (true)
		{
			//try different methods etc...
			if (shutdown) break;
		}
	}
	
	public void terminate(boolean shutdown)
	{
		this.shutdown = shutdown;
	}
}
