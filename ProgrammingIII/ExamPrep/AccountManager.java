
public class AccountManager
{
	public static void main(String[] args)
	{
		AccountTransactions acc1 = new AccountTransactions();
		
		acc1.run();
		
		int i = 0;
		while (i<10000)
		{
			i++;
		}
		
		acc1.terminate(true);
	}
}
