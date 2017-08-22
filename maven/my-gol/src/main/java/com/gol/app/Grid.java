package com.gol.app;

import java.util.ArrayList;
import java.util.Arrays;
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

	public List<Cell> GetNeighbours(int x, int y) {
		Cell cell1 = FindCell(x-1, y-1);
		Cell cell2 = FindCell(x+1, y+1);
		Cell cell3 = FindCell(x-1, y+1);
		Cell cell4 = FindCell(x+1, y-1);
		Cell cell5 = FindCell(x, y-1);
		Cell cell6 = FindCell(x, y+1);
		Cell cell7 = FindCell(x+1, y);
		Cell cell8 = FindCell(x-1, y);
		
		List<Cell> neighbours = new ArrayList<Cell>();
		List<Cell> temp = Arrays.asList(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8);
		for(Cell cell: temp){
			if(cell!=null){
				neighbours.add(cell);
			}
		}
		
		return neighbours;
	}

	public void Isolation() {			
		for(int x=0; x<4; x++){
    		for(int y=0; y<4; y++){
    			Cell cell = FindCell(x, y);
    			List<Cell> neighbours = GetNeighbours(cell.getX(), cell.getY());
    			
    			if(cell.isAlive()){
    				long count = neighbours.stream().filter(n->true == n.isAlive()).count();
    				if(count < 2){
    					cell.SetStatus(false);	
    				}    		
    			}
    		}
    	}
	}

	public void Suffercation() {
		for(int x=0; x<4; x++){
    		for(int y=0; y<4; y++){
    			Cell cell = FindCell(x, y);
    			List<Cell> neighbours = GetNeighbours(cell.getX(), cell.getY());
    			
    			if(cell.isAlive()){
    				long count = neighbours.stream().filter(n->true == n.isAlive()).count();
    				if(count > 3){
    					cell.SetStatus(false);	
    				}    		
    			}
    		}
    	}		
	}

	public void Ressurection() {
		for(int x=0; x<4; x++){
    		for(int y=0; y<4; y++){
    			Cell cell = FindCell(x, y);
    			List<Cell> neighbours = GetNeighbours(cell.getX(), cell.getY());
    			
    			if(!cell.isAlive()){
    				long count = neighbours.stream().filter(n->true == n.isAlive()).count();
    				if(count == 2 || count == 3){
    					cell.SetStatus(true);	
    				}    		
    			}
    		}
    	}				
	}
}