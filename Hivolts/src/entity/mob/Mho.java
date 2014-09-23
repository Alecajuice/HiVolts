package entity.mob;

import entity.Cell;

public class Mho extends Mob {

	public Mho(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int dx, int dy) {
		Cell destination = this.landlord.getGrid().getGrid()[this.x + dx][this.y + dy];
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
		
		int playerX = this.landlord.getGrid().findPlayer().x;
		int playerY = this.landlord.getGrid().findPlayer().y;
		
		//Directly horizontal
		if(this.y == playerY) {
			if(this.getX() < playerX) {
				move(1,0);
			}
			else {
				move(-1, 0);
			}
		}
		//Directly vertical
		else if(playerX < this.x) {
			move(-1,0);
		}
		
		if(playerY > this.y) {
			move(0,1);
		}
		if(playerY < this.y) {
			move(0,-1);
		}
	}
}
