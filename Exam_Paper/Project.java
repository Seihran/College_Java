import java.util.ArrayList;

public class Project
{
    private String projectName;
    private double cost;
    private int numEmployees;
    ArrayList<Employee> listOfWorkers;
    
    public Project(String name)
    {
        projectName = name;
        listOfWorkers = new ArrayList<Employee>();
    }
    
    public String getProjectName()
    {
        return projectName;
    }
    
    public double getCost()
    {
        for (Employee emp : listOfWorkers)
        {
            cost += emp.getSalary();
        }
        return cost;
    }
    
    public int getNumberEmployees()
    {
        for (Employee emp : listOfWorkers)
        {
            numEmployees += 1;
        }
        return numEmployees;
    }
    
    @Override
    public String toString()
    {
        String out = projectName;
        return out;
    }
}