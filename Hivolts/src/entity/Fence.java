package entity;

import java.awt.Color;
import java.awt.Graphics;

public class Fence extends Cell {

	public Fence(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void draw(int x_offset, int y_offset, int width, int height,Graphics g) {
		g.setColor(Color.blue);
		super.draw(x_offset, y_offset, width, height, g);
	}
	
}
