package entity;

import java.awt.Color;
import java.awt.Graphics;

public class Fence extends Cell {

	public Fence(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		int height = getGrid().getHeight();
		int width = getGrid().getWidth();
		
		g.setColor(Color.yellow);
		g.fillRect(getX()*(width/12), getY()*(width/12), width/12, height/12);
		g.setColor(Color.black);
		g.drawRect(getX()*(width/12), getY()*(width/12), width/12, height/12);
	}

}
