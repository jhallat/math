package com.jhallat.math.matricies.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jhallat.math.matrices.Dimension;
import com.jhallat.math.matrices.Matrix2D;
import com.jhallat.math.matrices.MatrixBuilder;

public class MatrixBuilderTest {

	@Test
	@DisplayName("Test matrix creation")
	public void testCreate() {
		
		Matrix2D actualMatrix = new MatrixBuilder()
			.addRow(1.0, 2.0, 3.0)
			.addRow(1.0, 2.0)
			.addRow(1.0)
			.addRow(1.0, 5.0, 2.0)
			.build();
		
		assertThat(actualMatrix.get(0,0), is(1.0));
		assertThat(actualMatrix.get(0,1), is(2.0));
		assertThat(actualMatrix.get(0,2), is(3.0));
		
		assertThat(actualMatrix.get(1,0), is(1.0));
		assertThat(actualMatrix.get(1,1), is(2.0));
		assertThat(actualMatrix.get(1,2), is(0.0));
		
		assertThat(actualMatrix.get(2,0), is(1.0));
		assertThat(actualMatrix.get(2,1), is(0.0));
		assertThat(actualMatrix.get(2,2), is(0.0));
		
		assertThat(actualMatrix.get(3,0), is(1.0));
		assertThat(actualMatrix.get(3,1), is(5.0));
		assertThat(actualMatrix.get(3,2), is(2.0));
		
		Dimension dimension = actualMatrix.getDimension();
		assertThat(dimension.getColumns(), is(3));
		assertThat(dimension.getRows(), is(4));
		
	}
	
}
