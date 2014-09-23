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
		int x = this.landlord.getGrid().findPlayer().x;
		int y = this.landlord.getGrid().findPlayer().y;
		if (x > this.x) {
			move(1, 0);
		} else if (x < this.x) {
			move(-1, 0);
		}
		if (y > this.y) {
			move(0, 1);
		}
		if (y < this.y) {
			move(0, -1);
		}
	}
}
