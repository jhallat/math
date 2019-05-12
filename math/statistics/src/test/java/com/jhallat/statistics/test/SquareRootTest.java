package com.jhallat.statistics.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jhallat.statistics.Statistics;

public class SquareRootTest {

	@Test
	@DisplayName("Square root of two")
	public void squareRootTwo() {
		
		BigDecimal squareRoot = Statistics.squareRoot(BigDecimal.valueOf(2), BigDecimal.valueOf(0.0001));
		assertThat(squareRoot, is(BigDecimal.valueOf(1.4142)));
	}
	
	@Test
	@DisplayName("Square root of half")
	public void squareRootHalf() {
		
		BigDecimal squareRoot = Statistics.squareRoot(BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.0001).setScale(4));
		assertThat(squareRoot, is(BigDecimal.valueOf(0.7071)));
	}
	
}
