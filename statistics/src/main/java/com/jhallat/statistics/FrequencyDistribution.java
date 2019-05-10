package com.jhallat.statistics;

import java.math.BigDecimal;
import java.util.List;

public interface FrequencyDistribution {

	List<FrequencySubdivision> getSubdivisions();

	BigDecimal getAverage();

	BigDecimal getVariance();

	BigDecimal getStandardDeviation();

	BigDecimal getOneStandardDeviationPct();

	BigDecimal getTwoStandardDeviationPct();

}