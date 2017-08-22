package com.gol.app;
import static org.junit.Assert.*;

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
}