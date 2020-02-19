import java.math.BigInteger;
import java.util.Scanner;

// Robert Dittmar
// Project Euler -- Problem 8 -- Largest Product in a Series
//
// Finds the largest product of n digits in a large integer.
//
// Inputs a string of numbers and number of digits to multiply together.
// Outputs the resulting largest product and the digits from which it was formed.

public class LargestProductInSeries {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger number = new BigInteger(s.next());
		int digits = s.nextInt();
		char[] numAsArr = number.toString().toCharArray();
		int first = 0;
		int last = digits-1;
		int product = 1;
		
		if (digits > numAsArr.length) {
			System.out.println("Invalid entry!");
		}
		else {
			int tempLast = 0;
			while (tempLast <= last) { //calculate inital product
				product *= Integer.parseInt(String.valueOf(numAsArr[tempLast]));
				tempLast++;
			}
			int tempFirst = first;
			int tempProduct = product;
			while (tempLast < numAsArr.length) {
				tempProduct /= Integer.parseInt(String.valueOf(numAsArr[tempFirst++]));
				tempProduct *= Integer.parseInt(String.valueOf(numAsArr[tempLast]));
				if (tempProduct > product) { //if new product is largest, replace product with new value
					product = tempProduct;
					last = tempLast;
					first = tempFirst;
				}
				tempLast++;
			}
			s.close();
			System.out.println("The highest product with " + digits + " digits is: " + product);
			System.out.print("Digits multiplied: ");
			while (first <= last) { //prints digits which make up product
				System.out.print(numAsArr[first++]);
				if (first <= last) {
					System.out.print(", ");
				}
			}
		}
		
	}
	
}
