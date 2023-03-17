import java.util.Random;

public class Rand
{
  public Rand()
  {
    Random rd = new Random();
    System.out.println(rd.nextLong());
  }

  public static void main(String args[])
  {
    Rand rd = new Rand();
  }
}
