import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class MakeChange {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		double price, tender;

		// Prompt user for price
		System.out.print("How much is the price? ");
		price = kb.nextDouble();

		// Get money tendered
		System.out.print("Enter payment amount? ");
		tender = kb.nextDouble();

		//Make change if needed
		if (price > tender) {
			System.out.println("You don't have enough money."); // Not enough
		} 
		else if (price == tender) {
			System.out.println("I love exact change!!"); // Exact amount
		} 
		else {
			makeChange(price, tender); // need to make change
		}

		kb.close();

	} // close main

	static void makeChange(double price, double tend) {
		double[] denom = { 20.00, 10.00, 5.00, 1.00, .25, .10, .05, .01 }; // breakdown of currency
		int[] chCnt = new int[denom.length];
		double chTot = round((tend - price), 2);

		for (int i = 0; i < denom.length; i++) {
			if (chTot < denom[i]) {
				chCnt[i] = 0;
				// System.out.println("Denom: " + denom[i] + "\t\tCh Count: " + chCnt[i] + "\tCh
				// remain: " + chTot);
			} else {
				chCnt[i] = (int) (chTot / denom[i]);
				chTot = round((chTot % denom[i]), 2);
				// System.out.println("Denom: " + denom[i] + "\t\tCh Count: " + chCnt[i] + "\tCh
				// remain: " + chTot);
			}
		}
		System.out.println("The price was $" + price + " and you gave me $" + tend);
		display(chCnt, price, tend);
	}

	// Display the change to the buyer
	public static void display(int[] chCnt, double price, double tend) {
		String[] money = { "Twenty(s)", "Ten(s)", "Five(s)", "One(s)", "Quarter(s)", "Dime(s)", "Nickel(s)",
				"Pennie(s)" };
		System.out.println("Your total change is $" + round((tend - price), 2));
		for (int i = 0; i < chCnt.length; i++) {
			if (chCnt[i] != 0) {
				System.out.println("\t" + chCnt[i] + "  " + money[i]);
			}
		}
	}

	// Need BigDecimal to round the double to 2 places.
	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

} // end
