package entity.mob;

import java.awt.Color;
import java.awt.Graphics;



import entity.Cell;

public class Mho extends Mob {

	public Mho(int x, int y, Cell landlord) {
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
		Cell destination = this.landlord.getGridPanel().getGrid()[this.x + dx][this.y + dy];
		if (destination.isOccupiedBy(Player.class)) {
			destination.getOccupant().destroy();
		}
		super.move(dx, dy);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	public void ai() {
		
		int playerX = this.landlord.getGridPanel().findPlayer().x;
		int playerY = this.landlord.getGridPanel().findPlayer().y;
		
		//Directly horizontal
		if(this.y == playerY) {
			if(this.x < playerX) {
				move(1, 0);
			}
			else {
				move(-1, 0);
			}
		}
		//Directly vertical
		else if(this.x == playerX) {
			if(this.y < playerY) {
				move(0, 1);
			}
			else {
				move(0, -1);
			}
		}
	}
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		g.setColor(Color.yellow);
		int xleft = x_offset + (x * (width + 1));
		int ytop = y_offset + (y * (height + 1));
		g.fillOval(xleft, ytop, width, height);
	}
}
