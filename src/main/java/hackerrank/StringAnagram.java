package main.java.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Two strings, and , are called anagrams if they contain all the same
 * characters in the same frequencies. For example, the anagrams of CAT are CAT,
 * ACT, TAC, TCA, ATC, and CTA.
 * 
 * Complete the function in the editor. If and are case-insensitive anagrams,
 * print "Anagrams"; otherwise, print "Not Anagrams" instead.
 * 
 * Input Format
 * 
 * The first line contains a string denoting . The second line contains a string
 * denoting .
 * 
 * Constraints
 * 
 * Strings and consist of English alphabetic characters. The comparison should
 * NOT be case sensitive. Output Format
 * 
 * Print "Anagrams" if and are case-insensitive anagrams of each other;
 * otherwise, print "Not Anagrams" instead.
 * 
 * Sample Input 0
 * 
 * anagram margana Sample Output 0
 * 
 * Anagrams Explanation 0
 * 
 * Character Frequency: anagram Frequency: margana A or a 3 3 G or g 1 1 N or n
 * 1 1 M or m 1 1 R or r 1 1 The two strings contain all the same letters in the
 * same frequencies, so we print "Anagrams".
 * 
 * Sample Input 1
 * 
 * anagramm marganaa Sample Output 1
 * 
 * Not Anagrams Explanation 1
 * 
 * Character Frequency: anagramm Frequency: marganaa A or a 3 4 G or g 1 1 N or
 * n 1 1 M or m 2 1 R or r 1 1 The two strings don't contain the same number of
 * a's and m's, so we print "Not Anagrams".
 * 
 * Sample Input 2
 * 
 * Hello hello Sample Output 2
 * 
 * Anagrams Explanation 2
 * 
 * Character Frequency: Hello Frequency: hello E or e 1 1 H or h 1 1 L or l 2 2
 * O or o 1 1 The two strings contain all the same letters in the same
 * frequencies, so we print "Anagrams".
 * 
 * @author rupesh sharma
 *
 */
public class StringAnagram {

	static boolean isAnagramUsingMap(String a, String b) {
		// Complete the function

		if (a.length() != b.length()) {
			return false;
		}

		a = a.toLowerCase();
		b = b.toLowerCase();
		
		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();

		for (int i = 0; i < a.length(); i++) {
			mapA.put(a.charAt(i), mapA.get(a.charAt(i)) == null ? 1 : mapA.get(a.charAt(i)) + 1);
			mapB.put(b.charAt(i), mapB.get(b.charAt(i)) == null ? 1 : mapB.get(b.charAt(i)) + 1);
		}

		if (mapA.equals(mapB)) {
			return true;
		}

		return false;
	}

	
	static boolean isAnagramUsingSubstring(String a, String b) {

		if (a.length() != b.length()) {
			return false;
		}

		a = a.toLowerCase();
		b = b.toLowerCase();

		char[] chars = a.toCharArray();

		for (char c : chars) {
			int index = b.indexOf(c);

			if (index != -1) {
				b = b.substring(0, index) + b.substring(index + 1, b.length());
			} else {
				return false;
			}
		}
		return b.isEmpty();
	}

	public static boolean isAnagramUsingArray(String a, String b) {

		a = a.toLowerCase();
		b = b.toLowerCase();
		
		int[] charCnt = new int[256];
		for (int i = 0; i < a.length(); i++) {
			charCnt[a.charAt(i)]++;
		}
		for (int i = 0; i < b.length(); i++) {
			charCnt[b.charAt(i)]--;
		}
		for (int i = 0; i < charCnt.length; i++) {
			if (charCnt[i] != 0)
				return false;
		}
		return true;
	}

	static boolean isAnagramUsingSorting(String a, String b) {

		a = a.toLowerCase();
		b = b.toLowerCase();
		
		boolean isAnagram = false;
		if (a.length() == b.length()) {
			char[] s1AsChar = a.toCharArray();
			char[] s2AsChar = b.toCharArray();
			Arrays.sort(s1AsChar);
			Arrays.sort(s2AsChar);
			isAnagram = Arrays.equals(s1AsChar, s2AsChar);
		}

		return isAnagram;

	}

	public static boolean isAnagramUsingSortingJava8(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		return Arrays.equals(a.chars().sorted().toArray(), b.chars().sorted().toArray());
	}

	static boolean isAnagramUsingCodepoint(String a, String b) {

		int len = a.length();
		if (len != b.length())
			return false;

		a = a.toLowerCase();
		b = b.toLowerCase();
		
		// collect codepoint occurrences in "a"
		Map<Integer, Integer> ocr = new HashMap<>(64);
		a.codePoints().forEach(c -> ocr.merge(c, 1, Integer::sum));

		// for each codepoint in "b", look for matching occurrence
		for (int i = 0, c = 0; i < len; i += Character.charCount(c)) {
			int cc = ocr.getOrDefault((c = Character.codePointAt(b, i)), 0);
			if (cc == 0)
				return false;
			ocr.put(c, cc - 1);
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();

		System.out.println("Using Map " + ((isAnagramUsingMap(a, b)) ? "Anagrams" : "Not Anagrams"));
		System.out.println("Using Substring " + ((isAnagramUsingSubstring(a, b)) ? "Anagrams" : "Not Anagrams"));
		System.out.println("Using Array " + ((isAnagramUsingArray(a, b)) ? "Anagrams" : "Not Anagrams"));
		System.out.println("Using Sorting " + ((isAnagramUsingSorting(a, b)) ? "Anagrams" : "Not Anagrams"));
		System.out.println("Using Sorting Java 8 " + ((isAnagramUsingSortingJava8(a, b)) ? "Anagrams" : "Not Anagrams"));
		System.out.println("Using Code point " + ((isAnagramUsingCodepoint(a, b)) ? "Anagrams" : "Not Anagrams"));
		
	}
}
