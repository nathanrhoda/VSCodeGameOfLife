package com.gol.app;

import java.util.ArrayList;
import java.util.List;

public class Grid
{
    public Grid() {                
        
    }
    
    public List<Cell> Cells = new ArrayList<Cell>();
	public int Dimensions;
	
    public void DisplaySomething(){
        System.out.println( "Something has been done!" );
    }

    public void IntializeGrid(){
    	for(int x=0; x<4; x++){
    		for(int y=0; y<4; y++){
    			Cells.add(new Cell(x, y));
    		}
    	}
    }

	public Cell FindCell(int x, int y) {
		Cell cell = Cells.stream()
							.filter(item->x == item.getX() && y == item.getY())
							.findAny()            
							.orElse(null);   
		return cell;
	}
}