package entity;

import graphics.GridPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import entity.mob.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;
	private Mob occupant = null;
	private GridPanel grid;

	//returns GridPanel
	public GridPanel getGridPanel() {
		return grid;
	}
	
	//Constructor, creates cell within grid
	public Cell(int x, int y, GridPanel grid) {
		this.x = x;
		this.y = y;
		this.grid = grid;
	}

	//Returns what kind of Mob(Player, Mho) is occupying this cell
	public Mob getOccupant() {
		return this.occupant;
	}

	/**
	 * Makes the cell contain a mob
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
	public <T> boolean contains(Class<T> c) {
		if (c.isInstance(this.occupant)) {
			return true;
		}
		return false;
	}

	//Returns x and y
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	//draw method taken from Conway
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
//		int xleft = x_offset + 1 + (x * (width + 1));
//		int ytop = y_offset + 1 + (y * (height + 1));
//		g.drawImage(lab, xleft, ytop, width, height, null);
		if(contains(Mho.class)) {
			((Mho)occupant).draw(x_offset, y_offset, width, height, g);
		}
		else if(contains(Player.class)) {
			((Player)occupant).draw(x_offset, y_offset, width, height, g);
		}
	}
}
