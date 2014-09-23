package entity.mob;

import entity.Cell;

public abstract class Mob extends Cell {
	protected Mob(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Moves entity based on params
	 * @param change in x coordinate
	 * @param change in y coordinate
	 */
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	public abstract void destroy();
}
