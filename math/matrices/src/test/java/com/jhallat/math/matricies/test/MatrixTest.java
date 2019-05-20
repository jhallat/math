package com.jhallat.math.matricies.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jhallat.math.matrices.Dimension;
import com.jhallat.math.matrices.Matrix2D;
import com.jhallat.math.matrices.MatrixBuilder;

public class MatrixTest {

	@Test
	@DisplayName("Test add matrices")
	public void testAddMatrices() {
		
		Matrix2D matrixOne = new MatrixBuilder()
				.addRow(1.0, 2.0, 3.0)
				.addRow(1.0, 2.0)
				.addRow(1.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D matrixTwo = new MatrixBuilder()
				.addRow(3.0, 2.0, 1.0)
				.addRow(1.0, 2.0, 4.0)
				.addRow(1.0, -1.0, -3.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D actualMatrix = matrixOne.add(matrixTwo);
		
		assertThat(actualMatrix.get(0,0), is(4.0));
		assertThat(actualMatrix.get(0,1), is(4.0));
		assertThat(actualMatrix.get(0,2), is(4.0));
		
		assertThat(actualMatrix.get(1,0), is(2.0));
		assertThat(actualMatrix.get(1,1), is(4.0));
		assertThat(actualMatrix.get(1,2), is(4.0));
		
		assertThat(actualMatrix.get(2,0), is(2.0));
		assertThat(actualMatrix.get(2,1), is(-1.0));
		assertThat(actualMatrix.get(2,2), is(-3.0));
		
		assertThat(actualMatrix.get(3,0), is(2.0));
		assertThat(actualMatrix.get(3,1), is(10.0));
		assertThat(actualMatrix.get(3,2), is(4.0));
	}

	
	@Test
	@DisplayName("Test subtract matrices")
	public void testSubtractMatrices() {
		
		Matrix2D matrixOne = new MatrixBuilder()
				.addRow(1.0, 2.0, 3.0)
				.addRow(1.0, 2.0)
				.addRow(1.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D matrixTwo = new MatrixBuilder()
				.addRow(3.0, 2.0, 1.0)
				.addRow(1.0, 2.0, 4.0)
				.addRow(1.0, -1.0, -3.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D actualMatrix = matrixOne.subtract(matrixTwo);
		
		assertThat(actualMatrix.get(0,0), is(-2.0));
		assertThat(actualMatrix.get(0,1), is(0.0));
		assertThat(actualMatrix.get(0,2), is(2.0));
		
		assertThat(actualMatrix.get(1,0), is(0.0));
		assertThat(actualMatrix.get(1,1), is(0.0));
		assertThat(actualMatrix.get(1,2), is(-4.0));
		
		assertThat(actualMatrix.get(2,0), is(0.0));
		assertThat(actualMatrix.get(2,1), is(1.0));
		assertThat(actualMatrix.get(2,2), is(3.0));
		
		assertThat(actualMatrix.get(3,0), is(0.0));
		assertThat(actualMatrix.get(3,1), is(0.0));
		assertThat(actualMatrix.get(3,2), is(0.0));
	}
	
	@Test
	@DisplayName("Test multiply scalar")
	public void testMultiplyScalar() {
		
		Matrix2D matrixOne = new MatrixBuilder()
				.addRow(1.0, 2.0, 3.0)
				.addRow(1.0, 2.0)
				.addRow(1.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D actualMatrix = matrixOne.multiply(3.0);
		
		assertThat(actualMatrix.get(0,0), is(3.0));
		assertThat(actualMatrix.get(0,1), is(6.0));
		assertThat(actualMatrix.get(0,2), is(9.0));
		
		assertThat(actualMatrix.get(1,0), is(3.0));
		assertThat(actualMatrix.get(1,1), is(6.0));
		assertThat(actualMatrix.get(1,2), is(0.0));
		
		assertThat(actualMatrix.get(2,0), is(3.0));
		assertThat(actualMatrix.get(2,1), is(0.0));
		assertThat(actualMatrix.get(2,2), is(0.0));
		
		assertThat(actualMatrix.get(3,0), is(3.0));
		assertThat(actualMatrix.get(3,1), is(15.0));
		assertThat(actualMatrix.get(3,2), is(6.0));
	}
	
	@Test
	@DisplayName("Test multiply row by scalar")
	public void testMultiplyRowByScalar() {
		
		Matrix2D matrixOne = new MatrixBuilder()
				.addRow(1.0, 2.0, 3.0)
				.addRow(1.0, 2.0)
				.addRow(1.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D actualMatrix = matrixOne.multiply(3.0, 3);
		
		assertThat(actualMatrix.get(0,0), is(1.0));
		assertThat(actualMatrix.get(0,1), is(2.0));
		assertThat(actualMatrix.get(0,2), is(3.0));
		
		assertThat(actualMatrix.get(1,0), is(1.0));
		assertThat(actualMatrix.get(1,1), is(2.0));
		assertThat(actualMatrix.get(1,2), is(0.0));
		
		assertThat(actualMatrix.get(2,0), is(1.0));
		assertThat(actualMatrix.get(2,1), is(0.0));
		assertThat(actualMatrix.get(2,2), is(0.0));
		
		assertThat(actualMatrix.get(3,0), is(3.0));
		assertThat(actualMatrix.get(3,1), is(15.0));
		assertThat(actualMatrix.get(3,2), is(6.0));
	}
	
	@Test
	@DisplayName("Test transpose")
	public void testTranspose() {
		
		Matrix2D matrixOne = new MatrixBuilder()
				.addRow(1.0, 2.0, 3.0)
				.addRow(1.0, 2.0)
				.addRow(1.0)
				.addRow(1.0, 5.0, 2.0)
				.build();
		
		Matrix2D actualMatrix = matrixOne.transpose();
		Dimension dimension = actualMatrix.getDimension();
		
		assertThat(dimension.getColumns(), is(4));
		assertThat(dimension.getRows(), is(3));
		
		assertThat(actualMatrix.get(0,0), is(1.0));
		assertThat(actualMatrix.get(0,1), is(1.0));
		assertThat(actualMatrix.get(0,2), is(1.0));
		assertThat(actualMatrix.get(0,3), is(1.0));

		assertThat(actualMatrix.get(1,0), is(2.0));
		assertThat(actualMatrix.get(1,1), is(2.0));
		assertThat(actualMatrix.get(1,2), is(0.0));
		assertThat(actualMatrix.get(1,3), is(5.0));

		assertThat(actualMatrix.get(2,0), is(3.0));
		assertThat(actualMatrix.get(2,1), is(0.0));
		assertThat(actualMatrix.get(2,2), is(0.0));
		assertThat(actualMatrix.get(2,3), is(2.0));

	}
}
