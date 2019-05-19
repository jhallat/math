package com.jhallat.combinatorics.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jhallat.combinatorics.Combinatorics;

public class PermutationTest {

	@Test
	@DisplayName("Select four of four")
	public void testSelectFourOfFour() {
		
		int n = 4;
		int m = 4;
		int result = Combinatorics.permutations(n, m);
		
		assertThat(result, is(24));
	}
	
	@Test
	@DisplayName("Select three of five")
	public void testSelectThreeOfFive() {
		
		int n = 5;
		int m = 3;
		int result = Combinatorics.permutations(n, m);
		
		assertThat(result, is(60));
	}
}
