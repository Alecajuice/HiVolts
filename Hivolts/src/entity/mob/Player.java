package entity.mob;

import java.awt.Color;
import java.awt.Graphics;

import entity.Cell;
import entity.Fence;

public class Player extends Mob {

	public Player(int x, int y, Cell landlord) {
		super(x, y, landlord);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move(int dx, int dy) {
		if((this.x == 0 && dx < 0) || (this.x == this.landlord.getGridPanel().getGrid().length - 1 && dx > 0)) {
			dx = 0;
		}
		if((this.y == 0 && dy < 0) || (this.y == this.landlord.getGridPanel().getGrid()[0].length - 1 && dy > 0)) {
			dy = 0;
		}
		System.out.println(x);
		Cell destination = this.landlord.getGridPanel().getGrid()[this.x + dx][this.y + dy];
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
		System.exit(0);
	}
	
	/**
	 * Jump to a random position
	 */
	public void jump() {
		
	}
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		g.setColor(Color.white);
		int xleft = x_offset + (x * (width + 1));
		int ytop = y_offset + (y * (height + 1));
		g.fillOval(xleft, ytop, width, height);
	}
	
}
