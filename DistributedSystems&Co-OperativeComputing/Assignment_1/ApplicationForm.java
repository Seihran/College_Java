import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ApplicationForm extends Remote
{
	public String readFile(Object o, long sessionID) throws RemoteException, InvalidSession;
	public void setName(String name, long sessionID) throws RemoteException, InvalidSession;
	public void setAddress(String address, long sessionID) throws RemoteException, InvalidSession;
	public void setEmail(String email, long sessionID) throws RemoteException, InvalidSession;
	public void setContact(String contact, long sessionID) throws RemoteException, InvalidSession;
	public void setStatement(String statement, long sessionID) throws RemoteException, InvalidSession;
}
