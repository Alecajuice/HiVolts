package entity;

import graphics.GridPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

import entity.mob.*;

public class Cell {
	protected int x, y;
	protected Color color = Color.black;
	//Occupants are the mobile entities that move across cells
	private Mob occupant = null;
	//Keeps a reference to grid in order to allow other classes to access the grid
	private GridPanel grid;

	//Constructor, creates cell within grid
	/* parameters:
	 		int row #
	 		int col #
	 		Gridpanel
	 */
	public Cell(int x, int y, GridPanel grid) {
		this.x = x;
		this.y = y;
		this.grid = grid;
	}

	//returns GridPanel
	public GridPanel getGridPanel() {
		return grid;
	}
	//Returns what kind of Mob(Player, Mho) is occupying this cell
	public Mob getOccupant() {
		return this.occupant;
	}
	//Returns x and y
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
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
		if (c.isInstance(this.occupant)) return true;
		return false;
	}
	
	//draw method taken from Conway
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		//int xleft = x_offset + 1 + (x * (width + 1));
		//int ytop = y_offset + 1 + (y * (height + 1));
		//g.drawImage(lab, xleft, ytop, width, height, null);
		if(contains(Mho.class)) {
			((Mho)occupant).draw(x_offset, y_offset, width, height, g);
		}
		else if(contains(Player.class)) {
			((Player)occupant).draw(x_offset, y_offset, width, height, g);
		}
	}
}
