/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
 * Client class to replicate ATM actions
*/
import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;

public class ATM
{
	public static void main(String args[])
	{
        int registryport = 20345;
        BigDecimal amount;

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
            Registry registry = LocateRegistry.getRegistry(registryport);
            BankInterface bank = (BankInterface) registry.lookup(name);
            long sessionID;

            //Takes command line argument for login
            if (args[1].compareToIgnoreCase("login") == 0)
            {
            	//Creates session ID given username and password
            	sessionID = bank.login(args[2], args[3]);
            	if (sessionID != 0)
				{
					System.out.println("Login Successfull. Session ID: " + sessionID);
				}
            	else
            	{
            		System.out.println("Login failed. Please try again.");
				}
            }
            else
            {
            	//Checks for valid session ID
            	if (Objects.equals(Long.parseLong(args[1]), bank.getSessionID()))
            	{
            		//Requests for account balance
            		if (args[2].compareToIgnoreCase("balance") == 0)
            		{
            			System.out.println("€" + bank.getBalance(Integer.parseInt(args[3]), Long.parseLong(args[1])));
            		}
            		//Deposits specified amount
            		else if (args[2].compareToIgnoreCase("deposit") == 0)
            		{
            			System.out.println(bank.deposit(Integer.parseInt(args[3]),
            		                     amount = new BigDecimal(Integer.parseInt(args[4])),
            		                     Long.parseLong(args[1])));
            		}
            		//Withdraws specified amount
            		else if (args[2].compareToIgnoreCase("withdraw") == 0)
            		{
            			System.out.println(bank.withdraw(Integer.parseInt(args[3]),
            		                     amount = new BigDecimal(Integer.parseInt(args[4])),
            		                     Long.parseLong(args[1])));
            		}
            		//Requests statement of transactions between given dates
            		else if (args[2].compareToIgnoreCase("statement") == 0)
            		{
            			System.out.println(bank.getStatement(args[4], args[5],
            				              Long.parseLong(args[1]), Integer.parseInt(args[3])));
            		}
            	}
            }
        }
        catch (Exception e)
        {
            System.err.println("ATM exception:");
            e.printStackTrace();
        }
    }
}
