package entity;

import graphics.GridPanel;

import java.awt.*;

import entity.mob.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;
	private Mob occupant = null;
	private GridPanel grid;

	public GridPanel getGrid() {
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

	public void draw(Graphics g) {
		int height = grid.getHeight();
		int width = grid.getWidth();
		g.setColor(Color.white);
		g.fillRect(getX()*(width/12), getY()*(width/12), width/12, height/12);
		g.setColor(Color.black);
		g.drawRect(getX()*(width/12), getY()*(width/12), width/12, height/12);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void draw(int x_offset, int y_offset, int width, int height,
			Graphics g) {
		// I leave this understanding to the reader
		int xleft = x_offset + 1 + (x * (width + 1));
		int xright = x_offset + width + (x * (width + 1));
		int ytop = y_offset + 1 + (y * (height + 1));
		int ybottom = y_offset + height + (y * (height + 1));
		Color temp = g.getColor();
		g.setColor(color);
		g.fillRect(xleft, ytop, width, height);
	}
}
