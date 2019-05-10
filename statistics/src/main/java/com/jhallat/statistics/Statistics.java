package com.jhallat.statistics;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class Statistics {

	private static final BigDecimal TWO = BigDecimal.valueOf(2);
	
	private Statistics() {}
	
	public static FrequencyDistribution frequencyDistribution(List<BigDecimal> values, int subdivisions) {
		
		FrequencyDistributionBuilder distributionBuilder = FrequencyDistributionBuilder.create();
		distributionBuilder.setSubdivisions(subdivisions).addValues(values);
		return distributionBuilder.calculate();
		
	}
	
	public static BigDecimal average(List<BigDecimal> values) {

		int scale = getMaximumScale(values) + 1;
		return average(values, scale);

	}
	
	public static BigDecimal average(List<BigDecimal> values, int scale) {
		BigDecimal sum = BigDecimal.ZERO;
		
		for (BigDecimal value : values) {
			sum = sum.add(value);
		}
				
		return sum.divide(BigDecimal.valueOf(values.size()), scale, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal variance(List<BigDecimal> values) {
		
		BigDecimal average = average(values);
		return variance(values, average);
	}
	
	protected static BigDecimal variance(List<BigDecimal> values, BigDecimal average) {
		BigDecimal sum = BigDecimal.ZERO;
		
		for (BigDecimal value : values) {
			sum = sum.add((value.subtract(average)).pow(2));
		}
		
		return sum.divide(BigDecimal.valueOf(values.size()), average.scale(), BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal standardDeviation(List<BigDecimal> values) {
		BigDecimal variance = variance(values);
		return standardDeviation(variance);
	}
	
	protected static BigDecimal standardDeviation(BigDecimal variance) {
		return squareRoot(variance, BigDecimal.valueOf(0.0001)).setScale(variance.scale(), BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal squareRoot(BigDecimal value, BigDecimal precision) {
		
		int scale = precision.scale();
		
		BigDecimal start;
		BigDecimal end;
		if (value.compareTo(BigDecimal.ONE) > 0) {
		    start = BigDecimal.ZERO;
		    end = value;
		} else {
			start = value;
			end = BigDecimal.ONE;
		}
		
		BigDecimal midpoint = value.divide(TWO);
		BigDecimal test = midpoint.multiply(midpoint);
		while (((test).subtract(value)).abs().compareTo(precision) > 0) {
			if (test.compareTo(value) > 0) {
				end = midpoint;
			} else {
				start = midpoint;
			}
			midpoint = ((end.subtract(start)).divide(TWO)).add(start);
			test = midpoint.multiply(midpoint);
		}
		
		return midpoint.round(new MathContext(scale));
	}
	
	protected static int getMaximumScale(List<BigDecimal> values) {
		int scale = 0;
		for (BigDecimal value : values) {
			if (value.scale() > scale) {
				scale = value.scale();
			}
		}
		return scale;
	}
}
