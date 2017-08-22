package com.gol.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void Create_WhereValidInputSupplied_ReturnsCell() {
		int x = 1;
		int y = 2;
		Cell cell = new Cell(x, y);
		assertNotNull(cell);
		assertEquals(x, cell.getX());
		assertEquals(y, cell.getY());
	}

}
