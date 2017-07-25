package com.gol.app;
import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {            
    
    @Test
    public void Grid_WhereItGetsCreated_Returns16Cells()    {
        Grid grid = new Grid();
        assertEquals(16, grid.Cells);
    }
        
    @Test
    public void Grid_WhereItGetsCreated_Returns2Dimensions() {
        Grid grid = new Grid();
        assertEquals(0, grid.Dimensions);
    }
}