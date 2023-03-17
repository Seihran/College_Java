import java.util.Scanner;

public class NewAccount
{
    Scanner input = new Scanner(System.in);
    NameList nameList = new NameList();
    PassList passList = new PassList();
    ExistingAccount existAccount;
    
    public NewAccount()
    {
        
    }
    
    public void add(ExistingAccount existAccount)
    {
        this.existAccount = existAccount;
        existAccount.add(nameList);
        existAccount.add(passList);
    }
    
    public void creation()
    {
        System.out.println("Enter username:");
        String userName = input.nextLine();
        nameList.setNameList(userName);
        
        System.out.println("Enter password:");
        String passWord = input.nextLine();
        passList.setPassList(passWord);
    }
}