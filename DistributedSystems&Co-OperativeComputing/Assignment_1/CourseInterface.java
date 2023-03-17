import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CourseInterface extends Remote
{
	public long getSessionID() throws RemoteException;
	public long login(String username, String password) throws RemoteException, InvalidLogin;
}
