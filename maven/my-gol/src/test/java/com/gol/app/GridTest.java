package com.gol.app;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GridTest {            
    
	Grid grid = new Grid();
	
	@Test
    public void Create_Successfully_Returns16CellsDeadCells()    {               
        long cellCount = grid.Cells.stream().filter(x->false == x.isAlive()).count();
        
        assertEquals(64, cellCount);
    }           

	
    @Test
    public void FindCell_WhereX1AndY2IsSupplied_ReturnsCellWithThoseCoordinates(){
    	int x = 1;
    	int y = 2;
    	Cell cell = grid.FindCell(x, y);
    	
    	assertEquals(x, cell.getX());
    	assertEquals(y, cell.getY());
    }
    
    @Test
    public void FindCell_WhereInvalidXAndYValuesSupplied_ReturnsNull(){
    	int x = 100;
    	int y = 211;
    	Cell cell = grid.FindCell(x, y);
    	
    	assertNull(cell);    	
    }
    
    @Test 
    public void GetNeighbours_WhereValidCellWithEightNeighboursSupplied_ReturnsEightNeighbours(){
    	int x = 1;
    	int y = 1;
    	List<Cell> neighbours = grid.GetNeighbours(x, y);
    	
    	assertEquals(8, neighbours.size());
    	
    }
    
    @Test 
    public void GetNeighbours_WhereValidCellWith3NeighboursSupplied_ReturnsThreeNeighbours(){
    	int x = 0;
    	int y = 0;
    	List<Cell> neighbours = grid.GetNeighbours(x, y);
    	
    	assertEquals(3, neighbours.size());
    }

    @Test 
    public void Isolation_WhereLiveCellHasLessThanTwoLiveNeighbours_MakesCellDead(){
    	int x = 0;
    	int y = 0;
    	
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(alive);
    	
    	grid.Isolation();
    	
    	cell = grid.FindCell(x, y);
    	assertFalse(cell.isAlive());
    }
    
    @Test 
    public void Isolation_WhereLiveCellHasMoreThanTwoLiveNeighbours_ReturnsCellAliveIsTrueNothingChanges(){
    	int x = 0;
    	int y = 0;
    	
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(alive);
    	
    	Cell cell1 = grid.FindCell(x+1, y);
    	cell1.SetStatus(alive);
    	
    	Cell cell2 = grid.FindCell(x, y+1);
    	cell2.SetStatus(alive);
    	
    	Cell cell3 = grid.FindCell(x+1, y+1);
    	cell3.SetStatus(alive);
    	
    	grid.Isolation();
    	
    	cell = grid.FindCell(x, y);
    	assertTrue(cell.isAlive());
    }
    
    @Test
    public void Suffercation_WhereLiveCellHasMoreThanThreeLiveNeighbours_ReturnsCellIsAliveIsFalse(){
    	int x = 1;
    	int y = 1;
    	
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(alive);
    	
    	Cell cell1 = grid.FindCell(x+1, y);
    	cell1.SetStatus(alive);
    	
    	Cell cell2 = grid.FindCell(x, y+1);
    	cell2.SetStatus(alive);
    	
    	Cell cell3 = grid.FindCell(x+1, y+1);
    	cell3.SetStatus(alive);
    	
    	Cell cell4 = grid.FindCell(x-1, y+1);
    	cell4.SetStatus(alive);
    	
    	grid.Suffercation();
    	
    	cell = grid.FindCell(x, y);
    	assertFalse(cell.isAlive());
    	
    }
    
    @Test
    public void Suffercation_WhereLiveCellHasLessThanThreeLiveNeighbours_ReturnsCellIsAliveIsFalse(){
    	int x = 1;
    	int y = 1;
    	
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(alive);
    	
    	Cell cell1 = grid.FindCell(x+1, y);
    	cell1.SetStatus(alive);
    	
    	Cell cell2 = grid.FindCell(x, y+1);
    	cell2.SetStatus(alive);
    	
    	Cell cell3 = grid.FindCell(x+1, y+1);
    	cell3.SetStatus(alive);
    	   	
    	grid.Suffercation();
    	
    	cell = grid.FindCell(x, y);
    	assertTrue(cell.isAlive());    
    }
    
    @Test 
    public void Ressurection_WhereDeadCellWithTwoLiveNeighbours_ReturnsCellIsAliveIsTrue(){
    	int x = 1;
    	int y = 1;
    	
    	boolean dead = false;
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(dead);
    	
    	Cell cell1 = grid.FindCell(x+1, y);
    	cell1.SetStatus(alive);
    	
    	Cell cell2 = grid.FindCell(x, y+1);
    	cell2.SetStatus(alive);
    	
    	   	
    	grid.Ressurection();
    	
    	cell = grid.FindCell(x, y);
    	assertTrue(cell.isAlive());    
    }
    
    @Test 
    public void Ressurection_WhereDeadCellWithOneLiveNeighbours_ReturnsCellIsAliveIsFalse(){
    	int x = 1;
    	int y = 1;
    	
    	boolean dead = false;
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(dead);
    	
    	Cell cell1 = grid.FindCell(x+1, y);
    	cell1.SetStatus(alive);
    	    
    	   	
    	grid.Ressurection();
    	
    	cell = grid.FindCell(x, y);
    	assertFalse(cell.isAlive());    
    }    
    
    @Test 
    public void Ressurection_WhereDeadCellWithFourLiveNeighbours_ReturnsCellIsAliveIsFalse(){
    	int x = 1;
    	int y = 1;
    	
    	boolean dead = false;
    	boolean alive = true;
    	Cell cell = grid.FindCell(x, y);
    	cell.SetStatus(dead);
    	
    	Cell cell1 = grid.FindCell(x+1, y);
    	cell1.SetStatus(alive);
    	    
    	Cell cell2 = grid.FindCell(x+1, y);
    	cell2.SetStatus(alive);
    	
    	Cell cell3 = grid.FindCell(x+1, y);
    	cell3.SetStatus(alive);
    	
    	Cell cell4 = grid.FindCell(x+1, y);
    	cell4.SetStatus(alive);
    	   	
    	grid.Ressurection();
    	
    	cell = grid.FindCell(x, y);
    	assertFalse(cell.isAlive());    
    }
    
    @Test
    public void SetSeed_WhereValidSeedSuppliedForCells_ReturnsIsAliveTrueForSeedCells(){
    	int x1 = 0;
    	int y1 = 0;
    	Cell cell1 = new Cell(x1, y1);
    	
    	int x2 = 2;
    	int y2 = 2;
    	Cell cell2 = new Cell(x2, y2);
    	
    	int x3 = 3;
    	int y3 = 3;    	    	
    	
    	List<Cell> seed = new ArrayList<Cell>();
    	seed.add(cell1);
    	seed.add(cell2);
    	
    	grid = new Grid(seed);
    	
    	Cell foundCell1 = grid.FindCell(x1, y1);
    	Cell foundCell2 = grid.FindCell(x2, y2);
    	Cell foundCell3 = grid.FindCell(x3, y3);
    	
    	assertTrue(foundCell1.isAlive());
    	assertTrue(foundCell2.isAlive());
    	assertFalse(foundCell3.isAlive());
    }
    
    @Test
    public void Tick_WhereSeedForFirstCellIsSet_ReturnsSeedCellIsAliveFalse(){
    	Cell cell = new Cell(0, 0);
    	List<Cell> seed = new ArrayList<Cell>();
    	seed.add(cell);    	
    	
    	grid = new Grid(seed);
    	Cell foundCell = grid.FindCell(cell.getX(), cell.getY());
    	assertTrue(foundCell.isAlive());
    	
    	grid.Tick();
    	
    	foundCell = grid.FindCell(cell.getX(), cell.getY()); 
    	
    	assertFalse(foundCell.isAlive());
    }
}