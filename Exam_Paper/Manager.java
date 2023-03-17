import java.util.ArrayList;

public class Manager extends Employee
{
    public Manager(String add, String name, int exp, double sal)
    {
       super(); 
       address = add;
       employeeName = name;
       experienceInYears = exp;
       monthlySalary = sal;
       listOfProjects = new ArrayList<Project>();
    }
    
    @Override
    public void addProject(Object obj)
    {
        if (obj instanceof Project)
        {
            Project project = (Project)obj;
            listOfProjects.add(project);
            project.listOfWorkers.add(this);
            return;
        }
        System.out.println("Not a valid project.");
    }
    
    @Override
    public void getProject()
    {
        for (Project pro : listOfProjects)
        {
            System.out.println(pro);
        }
    }
}