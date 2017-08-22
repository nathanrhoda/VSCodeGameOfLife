package com.gol.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void Create_WhereValidInputSupplied_ReturnsDeadCellByDefault() {
		int x = 1;
		int y = 2;
		Cell cell = new Cell(x, y);
		
		assertNotNull(cell);
		assertEquals(x, cell.getX());
		assertEquals(y, cell.getY());
		assertFalse(cell.isAlive());
	}

	@Test
	public void SetStatus_WhereStatusIsSetToAlive_ReturnsLiveCell(){
		boolean alive = true;
		int x = 0;
		int y = 0;		
		Cell cell = new Cell(x, y);
		
		cell.SetStatus(alive);
		
		assertTrue(cell.isAlive());
	}
	

	@Test
	public void SetStatus_WhereStatusIsSetToDead_ReturnsDeadCell(){
		boolean alive = true;
		boolean dead = false;
		int x = 0;
		int y = 0;		
		Cell cell = new Cell(x, y);
		
		cell.SetStatus(alive);
		
		cell.SetStatus(dead);
		
		assertFalse(cell.isAlive());
	}
}
