package entity.mob;

import java.awt.Color;
import java.awt.Graphics;



import entity.*;

public class Mho extends Mob {

	public boolean moved;
	
	public Mho(int x, int y, Cell landlord, int number) {
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
		if (destination.contains(Player.class)) {
			destination.getOccupant().destroy(dx, dy);
		}
		if(destination.contains(Mho.class)) {
			return false;
		}
		super.move(dx, dy);
		return true;
	}

	@Override
	public void destroy(int dx, int dy) {
		super.destroy(dx, dy);
	}

	public void ai() {
		if (!moved) {
			try {
				//Finds external data
				Cell[][] grid = this.landlord.getGridPanel().getGrid();
				int playerX = this.landlord.getGridPanel().findPlayer().x;
				int playerY = this.landlord.getGridPanel().findPlayer().y;
				
				//Mho will have moved
				moved = true;
				
				//Find the relative positions to travel 
				int dx = (this.x < playerX) ? 1:-1;
				int dy = (this.y < playerY) ? 1:-1;
				//Finds the 3 potential destination cells to check for obstacles
				Cell horiz = grid[this.x+dx][this.y];
				Cell verti = grid[this.x][this.y+dy];
				//Equivalent of nested if/else, checks relative x then relative y
				Cell diag = grid[this.x+dx][this.y+dy];
				
				//Forced to move directly horizontally/vertically if Player is in line of sight
				if(this.x==playerX && !verti.contains(Mho.class)) {
					move(0,dy);
					return;
				}
				else if(this.y==playerY && !verti.contains(Mho.class)) {
					move(dx, 0);
					return;
				}
				//Try moving diagonally
				else if(!diag.contains(Mho.class) && !diag.contains(Fence.class)) {
					move(dx, dy);
					return;
				}
				//If horizontal distance is larger, try moving that way
				else if(Math.abs(this.x-playerX) >= Math.abs(this.y-playerY)) {
					if(!horiz.contains(Mho.class) && !horiz.contains(Fence.class)) {
						move(dx, 0);
					}
					return;
				}
				//Last case, try moving vertically
				else {
					if(!verti.contains(Mho.class) && !verti.contains(Fence.class)) {
						move(0, dy);
						return;
					}
				}
				
				//If you could potentially move onto an electric fence, do so
				if(horiz.contains(Fence.class) || verti.contains(Fence.class) || diag.contains(Fence.class)) {
					this.destroy(dx, dy);
					return;
				}
			} catch (NullPointerException e) {}
		}
		return;
	}
	public void draw(int x_offset, int y_offset, int width, int height, Graphics g) {
		g.setColor(Color.yellow);
		int xleft = x_offset + (x * (width + 1));
		int ytop = y_offset + (y * (height + 1));
		g.fillOval(xleft, ytop, width, height);
	}
}
