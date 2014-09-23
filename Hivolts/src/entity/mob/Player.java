package entity.mob;

import java.awt.Graphics;

import entity.Cell;
import entity.Fence;

public class Player extends Mob {

	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move(int dx, int dy) {
		Cell destination = this.landlord.getGrid().getGrid()[this.x + dx][this.y + dy];
		if (destination.isOccupiedBy(Mho.class)) {
			this.destroy();
			return;
		}
		super.move(dx, dy);
	}

	/**
	 * Deletes this entity
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Jump to a random position
	 */
	public void jump() {
		
	}
	public void draw(Graphics g) {
		
	}
	
}
