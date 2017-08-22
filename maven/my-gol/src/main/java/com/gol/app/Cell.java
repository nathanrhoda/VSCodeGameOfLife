package com.gol.app;

public class Cell {

	
	private int _x;		
	public int getX(){
		return _x;		
	}
	
	private int _y;
	public int getY(){
		return _y;
	}
	
	private boolean _isAlive;
	public boolean isAlive() {
		return _isAlive;
	}	
	
	public Cell(int x, int y) {
		_x = x;
		_y = y;
	}



	public void SetStatus(boolean status) {
		_isAlive = status;		
	}

}
