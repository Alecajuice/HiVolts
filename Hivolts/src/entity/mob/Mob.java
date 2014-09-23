package entity.mob;

import entity.*;

public abstract class Mob<T> {
	protected Cell landlord;
	protected int x, y;
	
	protected Mob(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Moves entity based on params
	 * @param change in x coordinate
	 * @param change in y coordinate
	 */
	public void move(int dx, int dy) {
		int x = landlord.getX() + dx;
		int y = landlord.getY() + dy;
		this.landlord = landlord.getGrid().getCell(x, y);
	}
	public abstract void destroy();
}
