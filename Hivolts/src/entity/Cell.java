package entity;

import graphics.GridPanel;

import java.awt.*;
import entity.mob.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;
	private Mob occupant = null;
	private GridPanel grid;
		public GridPanel getGrid() {return grid;}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Makes the cell contain a mob
	 * @param tenant a Player or Mho or null
	 */
	public void occupy(Mob<? extends Mob> tenant) {
		occupant = tenant;
	}

	public <T> boolean isOccupiedBy(Class<T> c) {
		if(c.isInstance(this.occupant)) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
