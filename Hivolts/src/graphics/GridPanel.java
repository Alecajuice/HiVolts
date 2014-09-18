package graphics;

import entity.Cell;

import java.awt.*;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel
{

	private int height;
	private int width;
	private Cell[][] grid = new Cell[12][12];

	public GridPanel(int width, int height)
	{
		this.height = height;
		this.width = width;

		this.setSize(width, height);
	}
	
}
