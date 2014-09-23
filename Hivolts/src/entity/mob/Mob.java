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
		landlord.setX(landlord.getX()+dx);
		landlord.setY(landlord.getY()+dy);
	}
	public abstract void destroy();
	public Cell getLandLord() {
		return landlord;
	}
}
