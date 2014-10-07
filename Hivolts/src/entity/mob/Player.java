package entity.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Cell;
import entity.Fence;
import graphics.GridPanel;

//Player is of type Mob
public class Player extends Mob {
	private static BufferedImage img = null;

	// Constructor, creates a Player
	/* parameters:
	 * int row #
	 * int col #
	 * Cell to occupy
	 */
	public Player(int x, int y, Cell landlord) {
		super(x, y, landlord);
		try {
			img = ImageIO.read(new File("res/img/RaphiLangu.png"));
		} catch (IOException e) {
		}
	}

	//returns BufferedImage img
	public static BufferedImage getImage() {
		return img;
	}
	
	// Moves player
	// If player moves onto a Mho or Fence, deletes player
	@Override
	public boolean move(int dx, int dy) {
		if ((this.x == 0 && dx < 0)
				|| (this.x == this.landlord.getGridPanel().getGrid().length - 1 && dx > 0)) {
			dx = 0;
		}
		if ((this.y == 0 && dy < 0)
				|| (this.y == this.landlord.getGridPanel().getGrid()[0].length - 1 && dy > 0)) {
			dy = 0;
		}
		Cell destination = this.landlord.getGridPanel().getGrid()[this.x + dx][this.y
		                                                                       + dy];
		if (destination.contains(Mho.class)) {
			this.destroy(dx, dy);
			return true;
		}
		super.move(dx, dy);
		return true;
	}

	// Deletes this entity
	@Override
	public void destroy(int dx, int dy) {
		this.x = landlord.getX() + dx;
		this.y = landlord.getY() + dy;
		this.landlord.getGridPanel().getGui().gameOver();
		super.destroy(dx, dy);
	}

	// Jump to a random location
	public void jump() {
		Cell[][] grid = this.landlord.getGridPanel().getGrid();
		// -2 because of fences on the sides
		int width = this.landlord.getGridPanel().getW();
		int height = this.landlord.getGridPanel().getH();

		// +1 because of the fence on the side
		int x = (int) (Math.random() * width);
		int y = (int) (Math.random() * height);
		System.out.println(x);
		System.out.println(y);
		if (grid[x][y].getOccupant() instanceof Player
				|| grid[x][y] instanceof Fence) {
			jump(); // keeps trying until random location does not contain
			// Player or Fence
		} else move(x - getX(), y - getY());
	}

	// draw method taken from Conway
	public void draw(int x_offset, int y_offset, int width, int height,
			Graphics g) {
		int xleft = x_offset + (x * (width + 1)) + 1;
		int ytop = y_offset + (y * (height + 1)) + 1;
		g.drawImage(img, xleft, ytop, width, height, null);
	}

}
