package entity.mob;

import java.awt.Color;
import java.awt.Graphics;

import entity.*;


public abstract class Mob<T> {
	/*
	 * This Mob class is the basis for our mobs such as the Player and Mho
	 * it gives basic functions such as moving and destroying to all other mobs and allows
	 */
	protected Cell landlord;
	int x, y;
	

	/* Constructor, creates Mob 
	 * parameters:
	 * Takes a X and Y coordinate for drawing purposes
	 * Takes a Cell called landlord so it may access its neighbors
	 * Cell to occupy
	 */
	protected Mob(int x, int y, Cell landlord) {
		this.x = x;
		this.y = y;
		this.landlord = landlord;
	}
	
	// Returns x and y
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	/* This method moves the instane of mob to a different cell
	 * It takes delta x and y as its parameters
	 */
	public boolean move(int dx, int dy) {
		Cell destination = this.landlord.getGridPanel().getGrid()[this.x + dx][this.y
				+ dy];
		if (destination instanceof Fence) {
			this.destroy(dx, dy);
			return true;
		}
		this.x = landlord.getX() + dx;
		this.y = landlord.getY() + dy;
		destination.occupy((Mob<? extends Mob>) this);
		this.landlord.occupy(null);
		this.landlord = landlord.getGridPanel().getCell(this.x, this.y);
		return true;
	}

	/* This method takes the coordinates of the other player as
	 * a parameter and returns the distance between the two players
	 * Only used in multiplayer, unimplemented
	 */
	public double distanceTo(int x1, int y1) {
		int dx = Math.abs(this.x - x1);
		int dy = Math.abs(this.y - y1);
		return Math.sqrt(dx ^ 2 + dy ^ 2);
	}

	/* Takes dx and dy which is used in mob and player
	 * Destroys the current instance of mob by
	 * changing the value in its landlord to null
	 */
	public void destroy(int dx, int dy) {
		this.landlord.getGridPanel().getGrid()[this.x][this.y].occupy(null);
	}
}
