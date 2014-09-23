package entity.mob;

import java.awt.Color;
import java.awt.Graphics;

import entity.*;

public abstract class Mob<T> {
	protected Cell landlord;
	int x, y;
	
	protected Mob(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Moves entity based on params
	 * @param dx - change in x coordinate
	 * @param dy - change in y coordinate
	 */
	public void move(int dx, int dy) {
		Cell destination = this.landlord.getGrid().getGrid()[this.x + dx][this.y + dy];
		if (destination instanceof Fence) {
			this.destroy();
			return;
		}
		int x = landlord.getX() + dx;
		int y = landlord.getY() + dy;
		this.landlord = landlord.getGrid().getCell(x, y);
	}
	public void destroy() {
		this.landlord.occupy(null);
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
