package com.jhallat.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FrequencyDistributionBuilder {

	private static final BigDecimal TWO = BigDecimal.valueOf(2);
	
	private FrequencyDistributionImpl distribution;
	private List<BigDecimal> values = new ArrayList<>();
	private int subdivisionCount;
	
	private FrequencyDistributionBuilder() {
		this.distribution = new FrequencyDistributionImpl();
	}
	
	public static FrequencyDistributionBuilder create() {
		return new FrequencyDistributionBuilder();
	}
	
	public FrequencyDistributionBuilder setSubdivisions(int subdivisions) {
		this.subdivisionCount = subdivisions;
		return this;
	}
	
	public FrequencyDistributionBuilder addValue(BigDecimal value) {
		values.add(value);
		return this;
	}
	
	public FrequencyDistributionBuilder addValues(List<BigDecimal> values) {
		this.values.addAll(values);
		return this;
	}
	
	public FrequencyDistributionImpl calculate() {

		this.distribution.setAverage(Statistics.average(values));
		this.distribution.setVariance(Statistics.variance(values, this.distribution.getAverage()));
		this.distribution.setStandardDeviation(Statistics.standardDeviation(this.distribution.getVariance()));

		Collections.sort(values);
		int scale = Statistics.getMaximumScale(values);
		BigDecimal increment = BigDecimal.ONE.movePointLeft(scale);
		BigDecimal start = values.get(0);
		BigDecimal end = values.get(values.size() - 1);
		BigDecimal divisionSize = (end.subtract(start).add(increment)).divide(BigDecimal.valueOf(subdivisionCount));
		BigDecimal subdivisionStart = start;
		
		for (int i = 0; i < subdivisionCount; i++) {
			BigDecimal subdivisionEnd = subdivisionStart.add(divisionSize).subtract(increment);
			this.distribution.addSubdivision(subdivisionStart, subdivisionEnd);
			subdivisionStart = subdivisionEnd.add(increment);
		}
		
		BigDecimal startOneStdDev = this.distribution.getAverage().subtract(this.distribution.getStandardDeviation());
		BigDecimal endOneStdDev = this.distribution.getAverage().add(this.distribution.getStandardDeviation());
		BigDecimal startTwoStdDev = this.distribution.getAverage().subtract((this.distribution.getStandardDeviation().multiply(TWO)));
		BigDecimal endTwoStdDev = this.distribution.getAverage().add((this.distribution.getStandardDeviation().multiply(TWO)));
		int oneStdDevCount = 0;
		int twoStdDevCount = 0;
		
		List<FrequencySubdivision> subdivisions = distribution.getSubdivisions();
		int index = 0;
		FrequencySubdivisionImpl subdivision = (FrequencySubdivisionImpl) subdivisions.get(index);
		for (BigDecimal value : values) {
			if (value.compareTo(startOneStdDev) >= 0 && value.compareTo(endOneStdDev) <= 0) {
				oneStdDevCount++;
				twoStdDevCount++;
			} else if (value.compareTo(startTwoStdDev) >= 0 && value.compareTo(endTwoStdDev) <= 0) {
				twoStdDevCount++;
			}
			if (value.compareTo(subdivision.getStart()) >= 0 && value.compareTo(subdivision.getEnd()) <= 0) {
				subdivision.increment();
			} else {
				while (index + 1 < subdivisions.size()) {
					index++;
					subdivision = (FrequencySubdivisionImpl) subdivisions.get(index);
					if (value.compareTo(subdivision.getStart()) >= 0 && value.compareTo(subdivision.getEnd()) <= 0) {
						subdivision.increment();
						break;
					}
				}
			}
		}
		BigDecimal valueCount = BigDecimal.valueOf(values.size());
		distribution.setOneStandardDeviationPct(BigDecimal.valueOf(oneStdDevCount).divide(valueCount, 2, BigDecimal.ROUND_HALF_UP));
		distribution.setTwoStandardDeviationPct(BigDecimal.valueOf(twoStdDevCount).divide(valueCount, 2, BigDecimal.ROUND_HALF_UP));
		for (FrequencySubdivision subdivisionPct :  distribution.getSubdivisions()) {
			((FrequencySubdivisionImpl) subdivisionPct).setPercentage(BigDecimal.valueOf(subdivisionPct.getCount()).divide(valueCount, 2, BigDecimal.ROUND_HALF_UP));
		}
		
		return this.distribution;
	}
	

}
