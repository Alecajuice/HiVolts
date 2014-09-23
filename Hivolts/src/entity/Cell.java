package entity;

import java.awt.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {

	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}