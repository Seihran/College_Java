public class Test
{
    public static void main(String[] args)
    {
        String str1 = "Java";
        String str2 = "Ja";
        String str3 = "va";
        String str4 = str2 + str3;
        
        if (str1.equals(str4))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}