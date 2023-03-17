import java.text.DecimalFormat;
import javax.swing.*;

/*
 * The main class to run the program
 * 
 * Ciarán McCarthy
 * 6/2/20
 */

public class Main
{
	public static void main(String[] args)
	{
		Main test = new Main();
		
		test.test1();
	}
	
	public void test1()
	{
		Scan scan = new Scan();
		Translation trans = new Translation(scan.scan());
		String postFix = trans.Translate();
		Evaluation eval = new Evaluation(postFix);
		double result = eval.Evaluate();
		//Formats the resultant answer to 2 decimal places
		DecimalFormat numberFormat = new DecimalFormat("#0.00");
		
		JOptionPane.showMessageDialog(null, "The result of the expression is:\nInfix: " + scan.getInFix() +
				"\nPostfix: " + postFix + "\nResult: " + numberFormat.format(result));
	}
}