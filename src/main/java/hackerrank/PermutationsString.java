package main.java.hackerrank;

public class PermutationsString {

	public static void permutationsUsingRecursion(String s1) {
		permutationsUsingRecursion(s1, "");
	}

	public static void permutationsUsingRecursion(String s1, String s2) {

		if (s1.length() == 0) {
			System.out.println(s2);
		}

		for (int i = 0; i < s1.length(); i++) {
			permutationsUsingRecursion(s1.substring(0, i) + s1.substring(i + 1, s1.length()), s1.charAt(i) + s2);
		}

	}

	public static void main(String[] args) {
		permutationsUsingRecursion("tie");
	}
}
