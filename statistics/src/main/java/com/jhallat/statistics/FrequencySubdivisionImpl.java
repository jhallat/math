package com.jhallat.statistics;

import java.math.BigDecimal;

import lombok.Data;

@Data
class FrequencySubdivisionImpl implements FrequencySubdivision {

	private BigDecimal start;
	private BigDecimal end;
	private int count;
	private BigDecimal percentage;
	
	protected void increment() {
		count++;
	}

	
}
