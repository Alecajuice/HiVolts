package entity.mob;

public class Mho extends Mob {

	public Mho(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int dx, int dy) {
		super.move(dx, dy);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void ai() {
		
		int playerX = this.landlord.getGrid().findPlayer().x;
		int playerY = this.landlord.getGrid().findPlayer().y;
		
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
}
