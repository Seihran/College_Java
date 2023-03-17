/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
 * Server side replication of a bank
*/
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class Bank implements BankInterface
{
	private ArrayList<Account> accounts; // users accounts
	private BigDecimal balance1 = new BigDecimal(2000);
	private BigDecimal balance2 = new BigDecimal(1000);
	private BigDecimal balance3 = new BigDecimal(4500);
	private BigDecimal balance4 = new BigDecimal(12000);
	private long sessionID = 0;
	private Random rd = new Random();
	private String out = "";

	//Creates some accounts for testing and adds them to list
	public Bank() throws RemoteException
	{
		super();
		accounts = new ArrayList<Account>();
		Account acc1 = new Account("JohnMcGinley", "password1", balance1, 12345);
		Account acc2 = new Account("HopeCauthry", "password2", balance2, 23456);
		Account acc3 = new Account("AlexLanelle", "password3", balance3, 34567);
		Account acc4 = new Account("LouisFitzpatrick", "password4", balance4, 45678);
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		accounts.add(acc4);
	}
	
	@Override
	public long getSessionID() throws RemoteException
	{
		return sessionID;
	}

	//Login method
	@Override
	public long login(String username, String password) throws RemoteException, InvalidLogin
	{
		//Loops through list of accounts
		for (int i=0;i<accounts.size();i++)
		{
			//Checks username and password
			if (accounts.get(i).getAccName().toLowerCase().equals(username)
			    && accounts.get(i).getPass().toLowerCase().equals(password))
			{
				//Creates a random session ID
				sessionID = rd.nextLong();
				return sessionID;
			}
			//If login credentials are incorrect, throws exception
			else if (accounts.get(i).getAccName().toLowerCase().equals(username) != true
					 || accounts.get(i).getPass().toLowerCase().equals(password) != true)
			{
				throw new InvalidLogin("Invalid login credentials.");
			}
		}
		return 0;
	}

	//Deposit method
	@Override
	public String deposit(int accountNum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession
	{
		for (int i=0;i<accounts.size();i++)
		{
			//Checks account number and session ID
			if (accounts.get(i).getAccNum() == accountNum && this.sessionID == sessionID)
			{
				//Creates new transaction and adds to account history
				Transaction t = new Transaction(amount, "Deposit");
				accounts.get(i).addTransaction(t);
				//Prints transaction details
				System.out.println(t);
				//Returns new balance value
				accounts.get(i).setBalance(accounts.get(i).getBalance().add(amount));
				return out = "Deposit Successfull. New balance: €" + accounts.get(i).getBalance();
			}
			//If session ID is incorrect, throws exception
			else if (this.sessionID != sessionID)
			{
				throw new InvalidSession("Invalid session ID.");
			}
		}
		return out = "Transaction unsuccessfull.";
	}

	//Withdrawal method
	@Override
	public String withdraw(int accountNum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession
	{
		for (int i=0;i<accounts.size();i++)
		{
			if (accounts.get(i).getAccNum() == accountNum && this.sessionID == sessionID)
			{
				Transaction t = new Transaction(amount, "Withdrawal");
				accounts.get(i).addTransaction(t);
				System.out.println(t);
				accounts.get(i).setBalance(accounts.get(i).getBalance().subtract(amount));
				return out = "Withdrawal Successfull. New balance: €" + accounts.get(i).getBalance();
			}
			else if (this.sessionID != sessionID)
			{
				throw new InvalidSession("Invalid session ID.");
			}
		}
		return out = "Transaction unsuccessfull.";
	}

	//Checks current balance
	@Override
	public BigDecimal getBalance(int accountNum, long sessionID) throws RemoteException, InvalidSession
	{
		for (int i=0;i<accounts.size();i++)
		{
			if (accounts.get(i).getAccNum() == accountNum && this.sessionID == sessionID)
			{
				return accounts.get(i).getBalance();
			}
			else if (this.sessionID != sessionID)
			{
				throw new InvalidSession("Invalid session ID.");
			}
		}
		return null;
	}

	//Creates statement
	@Override
	public Statement getStatement(String from, String to, long sessionID, int accNum) throws RemoteException, InvalidSession
	{
		if (this.sessionID == sessionID)
		{
			for (int i=0;i<accounts.size();i++)
			{
				//If account number is correct, creates statement and prints details
				if (accounts.get(i).getAccNum() == accNum)
				{
					Statement s = new Statement(from, to, accounts.get(i));
					System.out.println(s);
					return s;
				}
			}
		}
		else if (this.sessionID != sessionID)
		{
			throw new InvalidSession("Invalid session ID.");
		}
		return null;
	}

	public static void main(String[] args)
	{
        int registryport = 20345;

        if (args.length > 0)
        {
        	registryport = Integer.parseInt(args[0]);
       	}

        System.out.println("RMIRegistry port = " + registryport);

        if (System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager());
        }

        try
        {
            String name = "Bank";
            BankInterface bank = new Bank();
            BankInterface stub = (BankInterface) UnicastRemoteObject.exportObject(bank, 0);
            Registry registry = LocateRegistry.getRegistry(registryport);
            registry.rebind(name, stub);
            System.out.println("BankInterface bound");
        }
        catch (Exception e)
        {
            System.err.println("BankInterface exception:");
            e.printStackTrace();
        }
    }
}
