package entity.mob;

import entity.Cell;

public abstract class Mob extends Cell {
	public Mob(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Moves entity based on params
	 * @param change in x coordinate
	 * @param change in y coordinate
	 */
	public abstract void move(int dx, int dy);
	public abstract void destroy();
}
