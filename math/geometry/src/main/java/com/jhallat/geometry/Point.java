package com.jhallat.geometry;

import java.math.BigDecimal;

public class Point {

	private final BigDecimal x;
	private final BigDecimal y; 
	
	public Point(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
	}
	
	public BigDecimal getX() {
		return this.x;
	}
	
	public BigDecimal getY() {
		return this.y;
	}
}
