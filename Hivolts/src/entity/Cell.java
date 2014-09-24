package entity;

import graphics.GridPanel;

import java.awt.*;

import entity.mob.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;
	private Mob occupant = null;
	private GridPanel grid;

	public GridPanel getGridPanel() {
		return grid;
	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Mob getOccupant() {
		return this.occupant;
	}

	/**
	 * Makes the cell contain a mob
	 * 
	 * @param tenant - a Player or Mho or null
	 */
	public void occupy(Mob<? extends Mob> tenant) {
		occupant = tenant;
	}
	
	/**
	 * Lets you see if the cell contains a certain object
	 * @param c class to be compared
	 * @return true if occupant class matches passed class
	 */
	public <T> boolean isOccupiedBy(Class<T> c) {
		if (c.isInstance(this.occupant)) {
			return true;
		}
		return false;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		
		g.setColor(Color.black);
		int xleft = x_offset + 1 + (x * (width + 1));
		int ytop = y_offset + 1 + (y * (height + 1));
		g.fillRect(xleft, ytop, width, height);
		if(isOccupiedBy(Mho.class)) {
			((Mho)occupant).draw(x_offset, y_offset, width, height, g);
		}
		else if(isOccupiedBy(Player.class)) {
			((Player)occupant).draw(x_offset, y_offset, width, height, g);
		}
	}
}
