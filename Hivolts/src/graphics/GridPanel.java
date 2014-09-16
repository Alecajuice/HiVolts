package graphics;

import grid.Tile;

import java.awt.*;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel {

	private int height;
	private int width;
	private Tile[][] grid = new Tile[12][12];

	public GridPanel(int width, int height) {
		this.height = height;
		this.width = width;
		
		this.setSize(width, height);
	}
	
}
