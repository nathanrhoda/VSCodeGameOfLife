package com.gol.app;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GridTest {            
    
	Grid grid = new Grid();
	
	@Before
	public void Setup(){
		grid.IntializeGrid();
	}
	
    @Test
    public void IntializeGrid_WhereAllRunsSuccessfully_Returns16Cells()    {               
        int cellCount = grid.Cells.size();
        
        assertEquals(16, cellCount);
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
    public void GetNeighbours_WhereValidCellSupplied_ReturnsEightNeighbours(){
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
    public void Isolation_WhereLiveCellHasMoreThanTwoLiveNeighbours_LeavesCellAlive(){
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
}