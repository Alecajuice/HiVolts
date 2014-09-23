package entity;

import graphics.GridPanel;

import java.awt.*;
import entity.mob.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;
	private Mob occupant = null;
	protected GridPanel grid;

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

	public void draw(Graphics g) {
		
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
