package entity.mob;

import entity.Cell;

public abstract class Mob extends Cell
{
	public Mob(int x, int y)
	{
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public abstract void move(int x, int y);
}
