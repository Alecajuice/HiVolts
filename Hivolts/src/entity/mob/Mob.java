package entity.mob;

import java.awt.Color;
import java.awt.Graphics;

import entity.*;

public abstract class Mob<T> {
	protected Cell landlord;
	int x, y;
	
	protected Mob(int x, int y, Cell landlord) {
		this.x = x;
		this.y = y;
		this.landlord = landlord;
	}
	
	/**
	 * Moves entity based on params
	 * @param dx - change in x coordinate
	 * @param dy - change in y coordinate
	 */
	public boolean move(int dx, int dy) {
		Cell destination = this.landlord.getGridPanel().getGrid()[this.x + dx][this.y + dy];
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
	
	//Used in 2 Player to find the closer player
	public double distanceTo(int x1, int y1) {
		int dx = Math.abs(this.x-x1);
		int dy = Math.abs(this.y-y1);
		return Math.sqrt(dx^2+dy^2);
	}
	
	public void destroy(int dx, int dy) {
		this.landlord.getGridPanel().getGrid()[this.x][this.y].occupy(null);
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
