package com.jhallat.combinatorics;

public class Combinatorics {

	//TODO confirm n > m
	public static int permutations(int n, int m) {
	
		return factorial(n) / factorial(n - m);
	}
	

	//TODO Confirm positive number
	private static int factorial(int n) {
		
		if (n == 1 || n == 0) {
			return 1;
		} 
		
		return n * factorial(n - 1);
		
	}
}
