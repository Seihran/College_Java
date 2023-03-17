import java.util.ArrayList;

public abstract class Employee
{
    String address;
    String employeeName;
    int experienceInYears;
    double monthlySalary;
    ArrayList<Project> listOfProjects;
    
    public abstract void addProject(Object obj);
    
    public void setSalary(double sal)
    {
        monthlySalary = sal;
    }
    
    public String getEmployeeName()
    {
        return employeeName;
    }
    
    public double getSalary()
    {
        return monthlySalary;
    }
    
    public int getExperienceInYears()
    {
        return experienceInYears;
    }
    
    public abstract void getProject();
}