public class CompanyTest
{
    public static void main(String[] args)
    {
        Company company = new Company("Ranra");
        
        Project project1 = new Project("Research Project 1");
        Project project2 = new Project("Research Project 2");
        Project project3 = new Project("Research Project 3");
        
        Manager manager1 = new Manager("Dublin", "Bob Wolmer", 10, 15000.0);
        Manager manager2 = new Manager("Galway", "Michael Madden", 8, 1200.0);
        
        manager1.addProject(project1);
        manager1.addProject(project2);
        manager1.setSalary(20000.00);
        manager2.addProject(project3);
        
        Contractor contractor1 = new Contractor("Dublin", "Fred Touhy", 6, 3000.0);
        Contractor contractor2 = new Contractor("Galway", "Tomy Hil", 2, 900.0);
        
        contractor1.addProject(project1);
        
        company.addEmployee(manager1);
        company.addEmployee(contractor1);
        company.addEmployee(manager2);
        company.addEmployee(contractor2);
        
        company.totalSalary();
        System.out.printf("Manager 1 works on the following projects: \n");
        manager1.getProject();
        System.out.printf("The total cost of %s is %f \n", project1.getProjectName(), company.getSalaryCost(project1));
        System.out.printf("Total number of employees in %s are: %d \n", project1.getProjectName(), company.getEmployees(project1));
    }
}