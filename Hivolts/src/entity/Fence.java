package entity;

import graphics.GridPanel;

import java.awt.Color;
import java.awt.Graphics;

//Fence is of type Cell
public class Fence extends Cell {
	//Constructor, creates a Fence
	public Fence(int x, int y, GridPanel grid) {
		super(x, y, grid);
	}
	
	//draw method taken from Conway
	public void draw(int x_offset, int y_offset, int width, int height,Graphics g) {
		g.setColor(Color.blue);
		int xleft = x_offset + 1 + (x * (width + 1));
		int ytop = y_offset + 1 + (y * (height + 1));
		g.fillRect(xleft, ytop, width, height);
	}
	
}
