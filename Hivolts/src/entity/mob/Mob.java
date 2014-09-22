package entity.mob;

import entity.Cell;

public abstract class Mob extends Cell {
	public Mob(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Moves entity to specified cell
	 * @param x coordinate to move to
	 * @param y coordinate to move to
	 */
	public abstract void move(int x, int y);
	public abstract void destroy();
}
