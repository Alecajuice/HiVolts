package entity.mob;

import java.awt.Color;
import java.awt.Graphics;



import entity.*;

public class Mho extends Mob {

	public Mho(int x, int y, Cell landlord) {
		super(x, y, landlord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean move(int dx, int dy){
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
		if(destination.isOccupiedBy(Mho.class)) {
			return false;
		}
		super.move(dx, dy);
		return true;
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	public void ai() {
		Cell[][] grid = this.landlord.getGridPanel().getGrid();
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
		else {
			int dx = (this.x < playerX) ? 1 : -1;
			int dy = (this.y < playerY) ? 1 : -1;
			
			//Is moving diagonally safe?
			if(!(grid[this.x+dx][this.y+dy] instanceof Fence)) {
				move(dx, dy);
			}
			//If the y distance is greater, 
			else if(Math.abs(this.x - playerX) < Math.abs(this.y - playerY)) {
				if((!(grid[this.x][this.y+dy] instanceof Fence))) {
					move(0, dy);
				}
			}
			else {
				if((!(grid[this.x+dx][this.y] instanceof Fence))) {
					move(dx, 0);
				}
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
