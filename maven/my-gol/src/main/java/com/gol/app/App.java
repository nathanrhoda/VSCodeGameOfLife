package com.gol.app;

import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        //System.out.println( "Hello World!" );
    	List<Cell> seed = new ArrayList<Cell>();
    	seed.add(new Cell(3, 3));
    	seed.add(new Cell(3, 2));
    	seed.add(new Cell(4, 3));
    	
    	///A
        Grid grid = new Grid(seed);
        System.out.println(grid.toString());
        
        while(true){
        	System.out.println("*******************************************************");
        	grid.Tick();
        	System.out.println(grid.toString());
        	Thread.sleep(3000);
        	System.out.println("*******************************************************");
        	
        }
               
    }
}
