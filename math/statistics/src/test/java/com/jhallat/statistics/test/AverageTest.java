package com.jhallat.statistics.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jhallat.statistics.Statistics;

public class AverageTest {

	@Test
	@DisplayName("Average test")
	public void averageTest() {
		
		List<BigDecimal> values = new ArrayList<>();
		values.add(BigDecimal.valueOf(1));
		values.add(BigDecimal.valueOf(2));
		values.add(BigDecimal.valueOf(3));
		values.add(BigDecimal.valueOf(4));
		values.add(BigDecimal.valueOf(5));
		
		BigDecimal average = Statistics.average(values);
		assertThat(average, is(BigDecimal.valueOf(3.0)));
		
	}
}
