package entity.mob;

public class Mho extends Mob {

	public Mho(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void ai() {
		
	}
}
