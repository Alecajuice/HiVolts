package entity.mob;

import java.awt.Color;
import java.awt.Graphics;

import entity.Cell;
import entity.Fence;
import graphics.GridPanel;

public class Player extends Mob {

	public Player(int x, int y, Cell landlord) {
		super(x, y, landlord);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean move(int dx, int dy) {
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
			return true;
		}
		super.move(dx, dy);
		return true;
	}

	/**
	 * Deletes this entity
	 */
	@Override
	public void destroy() {
		this.landlord.getGridPanel().getGui().gameOver();
		
	}
	
	/**
	 * Jump to a random position
	 */
	public void jump() {
		GridPanel panel = this.landlord.getGridPanel();
	}
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		g.setColor(Color.white);
		int xleft = x_offset + (x * (width + 1));
		int ytop = y_offset + (y * (height + 1));
		g.fillOval(xleft, ytop, width, height);
	}
	
}
