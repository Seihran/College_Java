import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CourseServer extends Remote
{
	public long getSessionID() throws RemoteException;
	public long login(String username, String password) throws RemoteException, InvalidLogin;
	public Object downloadFile(long sessionID) throws RemoteException, InvalidSession;
	public Object uploadFile(String info, long sessionID) throws RemoteException, InvalidSession;
}
