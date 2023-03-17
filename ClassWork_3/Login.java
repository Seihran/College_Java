import java.util.Scanner;

public class Login
{
    public static void main(String args[])
    {  
        Scanner input = new Scanner(System.in);
        NewAccount newAccount = new NewAccount();
        ExistingAccount existAccount = new ExistingAccount();
        newAccount.add(existAccount);
        
        System.out.println("New account? \n Please enter 'Yes'");
        System.out.println("Otherwise, press any key.");
        String check = input.nextLine();
        
        if ((check).equals("Yes") || (check).equals("yes"))
        {
            newAccount.creation();
            System.out.println("Please enter your login details.");
            existAccount.loginDetails();
        }
        else
        {
            existAccount.loginDetails();
        }
        
        if ((existAccount.getLogin()).equals("Login successful"))
        {
            System.out.println("Welcome User");
        }
        else
        {
            System.out.println("Please re-enter details.");
            existAccount.loginDetails();
        }
    }
}
