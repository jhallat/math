package com.jhallat.math.matrices;

public interface Matrix2D {

	Dimension getDimension();
	Matrix2D add(Matrix2D matrix) throws IllegalArgumentException;
	Matrix2D subtract(Matrix2D matrix) throws IllegalArgumentException;
	Matrix2D multiply(Double scalar);
	Matrix2D multiply(Double scalar, int row);
	Matrix2D transpose();
	Double get(int row, int column);
	
}
