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
	public void move(int dx, int dy) {
		Cell destination = this.landlord.getGridPanel().getGrid()[this.x + dx][this.y + dy];
		if (destination instanceof Fence) {
			this.destroy();
			return;
		}
		this.x = landlord.getX() + dx;
		this.y = landlord.getY() + dy;
		this.landlord = landlord.getGridPanel().getCell(this.x, this.y);
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
