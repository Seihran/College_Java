import java.util.Scanner;

public class ExistingAccount
{
    Scanner input = new Scanner(System.in);
    NameList nameList;
    PassList passList;
    int counter;
    String login;
    
    public ExistingAccount()
    {
        
    }
    
    public void add(NameList nameList)
    {
        this.nameList = nameList;
    }
    
    public void add(PassList passList)
    {
        this.passList = passList;
    }
    
    public String getLogin()
    {
        return login;
    }
    
    public void loginDetails()
    {
        counter = nameList.getCounter();
        
        System.out.println("Enter username:");
        String userName = input.nextLine();
        
        userName = nameList.checkName(userName);
        System.out.println("Your username is: " + userName);
        if ((userName).equals("Not found"))
        {
            login = "Not successful";
            return;
        }
        
        System.out.println("Enter password:");
        String passWord = input.nextLine();
        
        passWord = passList.checkPass(passWord);
        
        if ((passWord).equals("Not found") || nameList.getCounter() != passList.getCounter())
        {
            System.out.println("Incorrect password");
            login = "Not successful";
        }
        else
        {
            login = "Login successful";
            System.out.println(login);
        }
    }
}
