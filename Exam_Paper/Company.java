import java.util.ArrayList;

public class Company
{
    private String companyName;
    private double totalSalary;
    ArrayList<Employee> listOfEmployees;
    
    public Company(String name)
    {
        companyName = name;
        System.out.println("A company named " + name + " is created.");
        listOfEmployees = new ArrayList<Employee>();
    }
    
    public void addEmployee(Object obj)
    {
        if (obj instanceof Manager)
        {
            Employee employee = (Employee)obj;
            if (employee.getExperienceInYears() >= 3)
            {
                listOfEmployees.add(employee);
                System.out.println("Manager is added successfully in company employee list.");
                return;
            }
            System.out.println("Sorry this Manager cannot be added to the company.");
            return;
        }
        else if (obj instanceof Contractor)
        {
            Employee employee = (Employee)obj;
            if (employee.getExperienceInYears() >= 3)
            {
                listOfEmployees.add(employee);
                System.out.println("Constructor is added successfully in company employee list.");
                return;
            }
            System.out.println("Sorry this Contractor cannot be added to the company.");
            return;
        }
        System.out.println("Not a valid employee.");
    }
    
    public double getSalaryCost(Object obj)
    {
        if (obj instanceof Project)
        {
            Project project = (Project)obj;
            return project.getCost();
        }
        System.out.println("Not a valid project.");
        return 0;
    }
    
    public void totalSalary()
    {
        for (Employee emp : listOfEmployees)
        {
            System.out.println("The " + emp.getClass() + " " + emp.getEmployeeName()
            + " has a salary of " + emp.getSalary() + ".");
            totalSalary += emp.getSalary();
        }
        System.out.println("The total amount of employess monthly salary paid by "
        + companyName + "is: " + totalSalary + ".");
    }
    
    public int getEmployees(Object obj)
    {
        if (obj instanceof Project)
        {
            Project project = (Project)obj;
            return project.getNumberEmployees();
        }
        System.out.println("Not a valid project.");
        return 0;
    }
}