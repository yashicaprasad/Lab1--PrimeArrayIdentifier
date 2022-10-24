/*
 * Lab 01
 * Yashica Prasad
 * The ourpuse of this lab is to demovstrate iteration v recursion
 */

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeArrayIdentifier {

	public static void main(String[] args) {
		
		final int SORT_MAX_SIZE = 8;
		System.out.println("Please enter your input data on one line only.");
		
		Scanner myObj = new Scanner(System.in); 
		String rawDataInput = myObj.nextLine();
				
		String[] separatedInput = rawDataInput.split(" ");
		int[] rawNumbers = new int[separatedInput.length];
		
		if (separatedInput.length < 9) {
			for(int i = 0;i < separatedInput.length;i++) {
				rawNumbers[i] = Integer.parseInt(separatedInput[i]);
			}
			
			int[] numbers = Arrays.copyOfRange(rawNumbers, 1, rawNumbers.length);
			if(IsArrayPrimeIter(numbers, rawNumbers[0])) {
				System.out.println("Array was found to be prime using iteration");
			} else {
				System.out.println("Not a Prime Array using iteration");
			}
			
			if(IsArrayPrimeRecur(numbers, rawNumbers[0])) {
				System.out.println("Array was found to be prime using recursion");
			} else {
				System.out.println("Not a Prime Array using recursion");
			}
		}else {
		System.out.println("Sorry, no more than 8 values to be sorted.");	
		}
	}
	
	/*
	 * Algorithm IsArrayPrimeIter ( numbers, n ) 
	 * This algorithm checks if numbers is a prime array i.e. every element of numbers is prime
	 * Pre :    numbers – a non-empty array of integer numbers
	 * 			n – the actual size of the array
	 * Post: 
	 * Return: true or false
	 * 
	 * Evaluate for corner case- if an element < 2, it can not be prime
	 * return false
	 * 
	 * If an element of the array is divisible by a number between two and half of itself, it is not prime
	 * return false
	 * 
	 * If every element of the array is prime
	 * return true
	 */

	public static boolean IsArrayPrimeIter(int[] numbers, int n) {
		System.out.println("Entering IsArrayPrimeIter");

		for (int i = 0; i < n; i++) {
			// Corner case
			if (numbers[i] <= 1) {
				System.out.println("Leaving IsArrayPrimeIter");

				return false;
			}

			// Check from 2 to n-1
			for (int j = 2; j < numbers[i]/2; j++) {
				if (numbers[i] % j == 0) {
					System.out.println("Leaving IsArrayPrimeIter");

					return false;
				}

			}

		}

		System.out.println("Leaving IsArrayPrimeIter");

		return true;
	}

	/*
	 * Algorithm IsArrayPrimeRecur ( numbers, n ) 
	 * This algorithm checks if numbers is a prime array i.e. every element of numbers is prime
	 * Pre :    numbers – a non-empty array of integer numbers
	 * 			n – the actual size of the array
	 * Post: 
	 * Return: true or false
	 * 
	 * Evaluate for base case- if the last element (n-1) of numbers is prime
	 * return false
	 * 
	 * If there remain more elements in numbers
	 * return IsArrayPrimeRecur(numbers, n - 1)
	 * 
	 * Else
	 * return true
	 */

	public static boolean IsArrayPrimeRecur(int[] numbers, int n) {
		System.out.println("Entering IsArrayPrimeRecur");
		
		if (!IsPrimeRecur(numbers[n - 1], 2)) {
			System.out.println("Leaving IsArrayPrimeRecur");
			return false;
		} 
		
		if(n>1) {
		System.out.println("Leaving IsArrayPrimeRecur");
		return IsArrayPrimeRecur(numbers, n - 1);
		}
		else 
			return true;
	}
	
	/*
	 * Algorithm IsArrayPrimeRecur ( n, i ) 
	 * This algorithm checks if a provided number is prime or not
	 * Pre :    n – a provided integer to be evaluated as prime or not prime
	 * 			i – the base divisor
	 * Post: 
	 * Return: true or false
	 * 
	 * Evaluate for base case- 
	 * If n <= 2 and n = 2
	 * return false
	 * 
	 * If n is perfectly divisible by i
	 * return false
	 * 
	 * If the value of i reaches such that i * i > n, n is prime
	 * return true
	 * 
	 * If(i == 2)
	 * 	return IsPrimeRecur(n, i+1);
	 * 
	 * Else
	 * 	return IsPrimeRecur(n, i+2);
	 */

	static boolean IsPrimeRecur(int n, int i) {

		System.out.println("Entering IsPrimeRecur ");

		// Base cases
		if (n <= 2) {
			System.out.println("Leaving IsPrimeRecur ");
			return (n == 2) ? true : false;
		}
		if (n % i == 0) {
			System.out.println("Leaving IsPrimeRecur ");
			return false;
		}
		if (i * i > n) {
			System.out.println("Leaving IsPrimeRecur ");
			return true;
		}

		// Check for next divisor
		System.out.println("Leaving IsPrimeRecur ");
		if(i == 2) {
			return IsPrimeRecur(n, i+1);
		}
		else {
			return IsPrimeRecur(n, i+2);
		}
	}
}
