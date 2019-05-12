package com.jhallat.statistics.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jhallat.statistics.FrequencyDistribution;
import com.jhallat.statistics.FrequencySubdivision;
import com.jhallat.statistics.Statistics;

public class FrequencyDistributionTest {

	@Test
	@DisplayName("Basic distribution test")
	public void distributionTest() {
		
		List<BigDecimal> values = new ArrayList<BigDecimal>();
		values.add(BigDecimal.valueOf(1));
		values.add(BigDecimal.valueOf(1));
		values.add(BigDecimal.valueOf(1));
		values.add(BigDecimal.valueOf(2));
		values.add(BigDecimal.valueOf(2));
		values.add(BigDecimal.valueOf(2));
		values.add(BigDecimal.valueOf(3));
		values.add(BigDecimal.valueOf(3));
		values.add(BigDecimal.valueOf(3));
		values.add(BigDecimal.valueOf(3));
		values.add(BigDecimal.valueOf(8));
		values.add(BigDecimal.valueOf(8));
		values.add(BigDecimal.valueOf(10));
		values.add(BigDecimal.valueOf(10));
		values.add(BigDecimal.valueOf(10));
		
		FrequencyDistribution frequencyDistribution = Statistics.frequencyDistribution(values, 5);
		assertThat(frequencyDistribution, is(notNullValue()));
		
		List<FrequencySubdivision> subdivisions = frequencyDistribution.getSubdivisions();
		assertThat(subdivisions, is(notNullValue()));
		assertThat(subdivisions.size(), is(5));
		
		FrequencySubdivision subdivision = subdivisions.get(0);
		assertThat(subdivision, is(notNullValue()));
		assertThat(subdivision.getStart(), is(BigDecimal.valueOf(1)));
		assertThat(subdivision.getEnd(), is(BigDecimal.valueOf(2)));
		assertThat(subdivision.getCount(), is(6));
		assertThat(subdivision.getPercentage(), is(BigDecimal.valueOf(0.40).setScale(2, BigDecimal.ROUND_HALF_UP)));
		assertThat(frequencyDistribution.getAverage(), is(BigDecimal.valueOf(4.5)));
		assertThat(frequencyDistribution.getVariance(), is(BigDecimal.valueOf(12.0)));
		assertThat(frequencyDistribution.getStandardDeviation(), is(BigDecimal.valueOf(3.5)));
		assertThat(frequencyDistribution.getOneStandardDeviationPct(), is(BigDecimal.valueOf(0.80).setScale(2)));
		assertThat(frequencyDistribution.getTwoStandardDeviationPct(), is(BigDecimal.valueOf(1.00).setScale(2)));
		
		subdivision = subdivisions.get(4);
		assertThat(subdivision, is(notNullValue()));
		assertThat(subdivision.getStart(), is(BigDecimal.valueOf(9)));
		assertThat(subdivision.getEnd(), is(BigDecimal.valueOf(10)));
		assertThat(subdivision.getCount(), is(3));
		assertThat(subdivision.getPercentage(), is(BigDecimal.valueOf(0.20).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}
	
	@Test
	@DisplayName("Small number distribution test")
	public void smallNumberDistributionTest() {
		
		List<BigDecimal> values = new ArrayList<BigDecimal>();
		values.add(BigDecimal.valueOf(0.01));
		values.add(BigDecimal.valueOf(0.01));
		values.add(BigDecimal.valueOf(0.01));
		values.add(BigDecimal.valueOf(0.02));
		values.add(BigDecimal.valueOf(0.02));
		values.add(BigDecimal.valueOf(0.02));
		values.add(BigDecimal.valueOf(0.03));
		values.add(BigDecimal.valueOf(0.03));
		values.add(BigDecimal.valueOf(0.03));
		values.add(BigDecimal.valueOf(0.03));
		values.add(BigDecimal.valueOf(0.08));
		values.add(BigDecimal.valueOf(0.08));
		values.add(BigDecimal.valueOf(0.1));
		values.add(BigDecimal.valueOf(0.1));
		values.add(BigDecimal.valueOf(0.1));
		
		FrequencyDistribution frequencyDistribution = Statistics.frequencyDistribution(values, 5);
		assertThat(frequencyDistribution, is(notNullValue()));
		
		List<FrequencySubdivision> subdivisions = frequencyDistribution.getSubdivisions();
		assertThat(subdivisions, is(notNullValue()));
		assertThat(subdivisions.size(), is(5));
		
		FrequencySubdivision subdivision = subdivisions.get(0);
		assertThat(subdivision, is(notNullValue()));
		assertThat(subdivision.getStart(), is(BigDecimal.valueOf(0.01)));
		assertThat(subdivision.getEnd(), is(BigDecimal.valueOf(0.02)));
		assertThat(subdivision.getCount(), is(6));
		assertThat(subdivision.getPercentage(), is(BigDecimal.valueOf(0.40).setScale(2, BigDecimal.ROUND_HALF_UP)));
		
		subdivision = subdivisions.get(4);
		assertThat(subdivision, is(notNullValue()));
		assertThat(subdivision.getStart(), is(BigDecimal.valueOf(0.09)));
		assertThat(subdivision.getEnd(), is(BigDecimal.valueOf(0.10).setScale(2)));
		assertThat(subdivision.getCount(), is(3));
		assertThat(subdivision.getPercentage(), is(BigDecimal.valueOf(0.20).setScale(2, BigDecimal.ROUND_HALF_UP)));
	}
	
}
