package com.jhallat.geometry;

import java.math.BigDecimal;

public class Line {

	public final Point a;
	public final Point b;
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public BigDecimal getSlope() {
		
		BigDecimal y = a.getY().subtract(b.getY());
		BigDecimal x = a.getX().subtract(b.getX());
		
		
	}
}
