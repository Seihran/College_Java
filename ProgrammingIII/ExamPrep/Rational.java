
public class Rational
{
	private int numerator;
	private int denominator;
	
	public Rational(int num, int denom)
	{
		numerator = num;
		denominator = denom;
	}
	
	public void add(Object o)
	{
		Rational r2 = (Rational) o;
		this.setNum((this.getDenom()*r2.getNum())+(this.getNum()*r2.getDenom()));
		this.setDenom(this.getDenom()*r2.getDenom());
	}
	
	public void multiply(Object o)
	{
		Rational r2 = (Rational) o;
		this.setNum(this.getNum()*r2.getNum());
		this.setDenom(this.getDenom()*r2.getDenom());
	}
	
	public void setNum(int num)
	{
		numerator = num;
	}
	
	public void setDenom(int denom)
	{
		denominator = denom;
	}
	
	public int getNum()
	{
		return numerator;
	}
	
	public int getDenom()
	{
		return denominator;
	}
	
	public String toString()
	{
		return numerator + "/" + denominator;
	}
	
	public static void main(String[] args)
	{
		Rational a = new Rational(2, 3);
		Rational b = new Rational(3, 4);
		
		System.out.println(a);
		System.out.println(b);
		
		a.add(b);
		
		System.out.println(a);
		
		a.setNum(2);
		a.setDenom(3);
		
		a.multiply(b);
		
		System.out.println(a);
	}
}
