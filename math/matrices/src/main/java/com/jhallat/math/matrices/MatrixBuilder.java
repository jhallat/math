package com.jhallat.math.matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixBuilder {

	private List<List<Double>> elements = new ArrayList<>();
	private int maxCol = 0;
	
	public MatrixBuilder addRow(Double...values) {
		
		if (values.length > maxCol) {
			maxCol = values.length;
		}
		
		List<Double> row = new ArrayList<>();
		for (int i = 0; i < values.length; i++) {
			row.add(values[i]);
		}
		elements.add(row);
		
		return this;
	}
	
	public Matrix2D build() {
		
		for (List<Double> row : elements) {
			ArrayList<Double> rowImpl = (ArrayList<Double>) row;
			if (row.size() < maxCol) {
				int originalSize = row.size();
				for (int i = originalSize; i < maxCol; i++) {
					rowImpl.add(0.0);
				}
			}
		}
		return new Matrix2DImpl(elements);
	}
	
}
