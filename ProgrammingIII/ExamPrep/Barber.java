
public class Barber implements Runnable
{
	private Bench bench;
	
	public Barber(Bench bench)
	{
		this.bench = bench;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			if (bench.get() != null)
			{
				bench.get().cuthair();
				System.out.println("Haircut complete");
			}
			else
			{
				try
				{
					sleep((int) (Math.random() * 50000));
				}
				catch (InterruptedException e) { }
			}
			try
			{
				sleep((int) (Math.random() * 5000));
			}
			catch (InterruptedException e) { }
		}
	}

}
