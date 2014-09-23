package entity.mob;

import entity.Cell;
import entity.Fence;

public class Player extends Mob {

	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int dx, int dy) {
		Cell destination = this.grid.getGrid()[this.x+dx][this.y+dy];
		if(destination instanceof Fence || destination instanceof Mho)
		{
			this.destroy();
			return;
		}
		this.x += dx;
		this.y += dy;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void jump() {
		
	}
}
