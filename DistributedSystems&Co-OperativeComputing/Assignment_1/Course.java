import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;

public class Course
{
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
			String name = "Course";
			Registry registry = LocateRegistry.getRegistry(registryport);
			CourseServer course = (CourseServer) registry.lookup(name);
			AppFormv1 form = (AppFormv1) registry.lookup(name);
			long sessionID;

			//Takes command line argument for login
			if (args[1].compareToIgnoreCase("login") == 0)
			{
				//Creates session ID given username and password
				sessionID = course.login(args[2], args[3]);
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
				if (Objects.equals(Long.parseLong(args[1]), course.getSessionID()))
				{
					Object f = course.downloadFile(course.getSessionID());
					String info = form.readFile(f, course.getSessionID());
					form.setName(info, course.getSessionID());
					form.setAddress(info, course.getSessionID());
					form.setEmail(info, course.getSessionID());
					form.setContact(info, course.getSessionID());
					form.setStatement(info, course.getSessionID());
					
					course.uploadFile(info, course.getSessionID());
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("Course Server exception:");
			e.printStackTrace();
		}
	}
}
