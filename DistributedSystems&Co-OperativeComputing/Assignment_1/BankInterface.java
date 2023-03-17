/*
 * @author (Ciarán McCarthy)
 * @student id: 17102168
 * @version (13/03/2021)
 * 
*/
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankInterface extends Remote
{
	//Remote object that defines different bank transactions
	public long getSessionID() throws RemoteException;
	public long login(String username, String password) throws RemoteException, InvalidLogin;
	public String deposit(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession;
	public String withdraw(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession;
	public BigDecimal getBalance(int accountnum, long sessionID) throws RemoteException, InvalidSession;
	public Statement getStatement(String from, String to, long sessionID, int accNum) throws RemoteException, InvalidSession;
}
