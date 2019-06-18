package com.jhallat.math.matrices;

import java.util.ArrayList;
import java.util.List;

class Matrix2DImpl implements Matrix2D {

	private final List<List<Double>> elements;
	private final Dimension dimension;
	
	protected Matrix2DImpl(List<List<Double>> elements) {
		this.elements = elements;
		this.dimension = new Dimension(elements.size(), elements.get(0).size());
	}
	
	@Override
	public Dimension getDimension() {
		return this.dimension;
	}
	
	@Override
	public Double get(int row, int column) {
		return elements.get(row).get(column);
	}
	
	@Override
	public Matrix2D add(Matrix2D matrix) throws IllegalArgumentException {
		
		if (!this.dimension.equals(matrix.getDimension())) {
			throw new IllegalArgumentException("Matrix addition requires matrices of the same dimension");
		}
		
		List<List<Double>> addedMatrix = new ArrayList<>();
		
		for (int i = 0; i < elements.size(); i++) {
			List<Double> currentRow = elements.get(i);
			List<Double> addedRow = new ArrayList<>();
			for (int j = 0; j < currentRow.size(); j++) {
				addedRow.add(currentRow.get(j) + matrix.get(i, j));
			}
			addedMatrix.add(addedRow);
		}
		
		return new Matrix2DImpl(addedMatrix);
		
	}
	
	@Override
	public Matrix2D subtract(Matrix2D matrix) throws IllegalArgumentException {
		
		if (!this.dimension.equals(matrix.getDimension())) {
			throw new IllegalArgumentException("Matrix addition requires matrices of the same dimension");
		}
		
		List<List<Double>> subtractedMatrix = new ArrayList<>();
		
		for (int i = 0; i < elements.size(); i++) {
			List<Double> currentRow = elements.get(i);
			List<Double> subtractedRow = new ArrayList<>();
			for (int j = 0; j < currentRow.size(); j++) {
				subtractedRow.add(currentRow.get(j) - matrix.get(i, j));
			}
			subtractedMatrix.add(subtractedRow);
		}
		
		return new Matrix2DImpl(subtractedMatrix);
		
	}
	
	@Override
	public Matrix2D multiply(Double scalar) {
		
		List<List<Double>> multipliedMatrix = new ArrayList<>();
		
		for (int i = 0; i < elements.size(); i++) {
			List<Double> currentRow = elements.get(i);
			List<Double> multipliedRow = new ArrayList<>();
			for (int j = 0; j < currentRow.size(); j++) {
				multipliedRow.add(currentRow.get(j) * scalar);
			}
			multipliedMatrix.add(multipliedRow);
		}
		
		return new Matrix2DImpl(multipliedMatrix);
		
	}

	@Override
	public Matrix2D multiply(Double scalar, int row) {
		
		List<List<Double>> multipliedMatrix = new ArrayList<>();
		
		for (int i = 0; i < elements.size(); i++) {
			List<Double> currentRow = elements.get(i);
			List<Double> multipliedRow = new ArrayList<>();
			if (i == row) {
				for (int j = 0; j < currentRow.size(); j++) {
					multipliedRow.add(currentRow.get(j) * scalar);
				}
			} else {
				multipliedRow.addAll(currentRow);
			}
			multipliedMatrix.add(multipliedRow);
		}
		
		return new Matrix2DImpl(multipliedMatrix);
		
	}
	
	
	@Override
	public Matrix2D transpose() {
		
		List<List<Double>> transposedMatrix = new ArrayList<>();
		
		for (int col = 0; col < elements.get(0).size(); col++) {
			List<Double> transposedRow = new ArrayList<>();
			for (int row = 0; row < elements.size(); row++) {
				transposedRow.add(this.get(row, col));
			}
			transposedMatrix.add(transposedRow);
		}
		
		return new Matrix2DImpl(transposedMatrix);
	}
}
