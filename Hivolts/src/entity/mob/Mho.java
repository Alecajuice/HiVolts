package entity.mob;

public class Mho extends Mob {

	public Mho(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void ai() {
		int x = getLandLord().grid.findPlayer().getX();
		int y = grid.findPlayer().getY();
		if(x > getX()) {
			move(1,0);
		}
		else if(x < getX()) {
			move(-1,0);
		}
		if(y > getY()) {
			move(0,1);
		}
		if(y < getY()) {
			move(0,-1);
		}
	}
}
