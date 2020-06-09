package main.java.hackerrank;

import java.util.Scanner;

/**
 * 
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backward or forward.(Wikipedia) Given a string , print Yes if
 * it is a palindrome, print No otherwise.
 * 
 * Constraints
 * 
 * will consist at most lower case english letters. Sample Input
 * 
 * madam Sample Output
 * 
 * Yes
 * 
 * @author rupesh sharma
 *
 */
public class StringPalindrome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		usingReverse(A);
		usingForLoop(A);
		usingWhileLoop(A);
		usingRecursion(A, 0, A.length() - 1);

		sc.close();
	}

	private static void usingReverse(String str) {
		System.out.println(str.equals(new StringBuffer(str).reverse().toString()) ? "Yes usingRecursive" : "No");
	}

	private static void usingForLoop(String str) {

		for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
			if (!(str.charAt(i) == str.charAt(j))) {
				System.out.println("No");
				return;
			}

		}
		System.out.println("Yes usingForLoop");
	}

	private static void usingWhileLoop(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			if (!(str.charAt(i) == str.charAt(j))) {
				System.out.println("No");
				return;
			}
			i++;
			j--;

		}
		System.out.println("Yes usingWhileLoop");
	}

	private static void usingRecursion(String str, int start, int end) {

		if (start == end) {
			System.out.println("Yes usingRecursion");
			return;
		}

		if (start > end) {
			System.out.println("Yes usingRecursion");
			return;
		}

		if (!(str.charAt(start) == str.charAt(end))) {
			System.out.println("No");
			return;
		}else {
			usingRecursion(str, start+1, end-1);
		}

	}
}
