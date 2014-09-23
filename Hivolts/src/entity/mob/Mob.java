package entity.mob;

import entity.*;

public abstract class Mob<T> {
	private Cell landlord;
	
	protected Mob(int x, int y) {
		
		// TODO Auto-generated constructor stub
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
