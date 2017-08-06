import java.math.BigDecimal;
import java.math.RoundingMode;

/* In the cash register we will calculate the amount of change returned to a customer based on the purchase 
 * price and the amount tendered. We will also notify the attendant how many of each piece of 
 * currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer. 
 * Change should be provided using the largest bill and coin denominations as possible. Denominations that 
 * are not used should not be displayed.
 * 
 * US1: The user is prompted asking for the price of the item.
	
	US2: The user is then prompted asking how much money was tendered by the customer.
	
	US3: Display an appropriate message if the customer provided too little money or the exact amount.

	US4: If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.
*/

//import java.util.*;

public class MakeChange {

	// {100.00, 50.00, 20.00, 10.00, 5.00, 1.00, .25, .10, .05, .01}

	public static void main(String[] args) {

		// Scanner kb = new Scanner(System.in);
		double price, tender;

		// Prompt user for price
		// System.out.print("How much is the price? ");
		price = .67; // kb.nextDouble();

		// Get money tendered
		// System.out.print("Enter payment amount? ");
		tender = 1.00; // kb.nextDouble();

		makeChange(price, tender);

		// kb.close();

	} // close main

	static void makeChange(double price, double tend) {
		double[] denom = { 1.00, .25, .10, .05, .01 }; // breakdown of currency
		int [] chCnt = new int [denom.length];
		double chTot = round((tend % price), 2);
		
		for (int i = 0; i < denom.length; i++) {
			if (chTot <= denom[i]) {
				chCnt[i] = 0;
			}
			else {
				chCnt [i] = (int)(chTot / denom[i]);
				System.out.print("Change Total: " +chTot);
				System.out.print("\t\tChange Amt: " +denom[i]);
				chTot = round((chTot % denom[i]) , 2);
				System.out.println("\t\tChange Count: " +chCnt[i]);
			}
		}
	}
	
	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

} // end
