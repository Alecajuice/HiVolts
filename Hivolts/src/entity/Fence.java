package entity;

import graphics.GridPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Fence class
/* Fences are a special type of cell. In our game, they are Mr. Kuszmauls.
 */
public class Fence extends Cell {
	public static BufferedImage img;
	
	//Constructor, creates a Fence
	/* parameters:
			int row #
			int col #
			Gridpanel
	*/
	public Fence(int x, int y, GridPanel grid) {
		super(x, y, grid);
	}
	
	//draw method taken from Conway
	public void draw(int x_offset, int y_offset, int width, int height,Graphics g) {
		int xleft = x_offset + (x * (width + 1)) + 1;
		int ytop = y_offset + (y * (height + 1)) + 1;
		g.drawImage(img, xleft, ytop, width, height, null);
	}
	
}
