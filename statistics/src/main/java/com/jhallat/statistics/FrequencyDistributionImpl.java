package com.jhallat.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FrequencyDistributionImpl implements FrequencyDistribution {

	private List<FrequencySubdivision> subdivisions = new ArrayList<>();
	private BigDecimal average = BigDecimal.ZERO;
	private BigDecimal variance = BigDecimal.ZERO;
	private BigDecimal standardDeviation = BigDecimal.ZERO;
	private BigDecimal oneStandardDeviationPct = BigDecimal.ZERO;
	private BigDecimal twoStandardDeviationPct = BigDecimal.ZERO;
	
	protected FrequencyDistributionImpl() {}
	
	@Override
	public List<FrequencySubdivision> getSubdivisions() {
		return Collections.unmodifiableList(this.subdivisions);
	}
	
	protected void setAverage(BigDecimal average) {
		this.average = average;
	}
	
	@Override
	public BigDecimal getAverage() {
		return this.average;
	}
	
	protected void setVariance(BigDecimal variance) {
		this.variance = variance;
	}
	
	@Override
	public BigDecimal getVariance() {
		return this.variance;
	}
	
	protected void setStandardDeviation(BigDecimal standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	
	@Override
	public BigDecimal getStandardDeviation() {
		return this.standardDeviation;
	}

	@Override
	public BigDecimal getOneStandardDeviationPct() {
		return oneStandardDeviationPct;
	}

	protected void setOneStandardDeviationPct(BigDecimal oneStandardDeviationPct) {
		this.oneStandardDeviationPct = oneStandardDeviationPct;
	}

	@Override
	public BigDecimal getTwoStandardDeviationPct() {
		return twoStandardDeviationPct;
	}

	protected void setTwoStandardDeviationPct(BigDecimal twoStandardDeviationPct) {
		this.twoStandardDeviationPct = twoStandardDeviationPct;
	}	
	
	protected void addSubdivision(BigDecimal start, BigDecimal end) {
		FrequencySubdivisionImpl subdivision = new FrequencySubdivisionImpl();
		subdivision.setStart(start);
		subdivision.setEnd(end);
		subdivisions.add(subdivision);
	}


	
}
