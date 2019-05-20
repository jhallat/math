package com.jhallat.math.matrices;

import lombok.Getter;

public final class Dimension {

	@Getter
	private final int rows;
	@Getter
	private final int columns;
	
	protected Dimension(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (object instanceof Dimension) {
			Dimension dimension = (Dimension) object;
			return this.rows == dimension.getRows() && this.columns == dimension.getColumns();
		}
		return false;
	}
}
