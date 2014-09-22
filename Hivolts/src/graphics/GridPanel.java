package graphics;

import entity.Cell;
import entity.Fence;

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
	
	public void initAllCells() {
		initBorders();
		initInsideFences();
		initEnemies();
		initPlayer();
	}
	public void initBorders() {
		for(int i = 0; i < 12; i++) {
			grid[0][i] = new Fence(0,i);
			grid[11][i] = new Fence(0,i);
		}
		for(int i = 1; i <11; i++) {
			grid[1][i] = new Fence(1,i);
			grid[11][i] = new Fence(11,i);
		}
	}
	public void initInsideFences() {
		for(int i = 0; i < 20; i++) {
			Fence newFence = initRandFence();
			if(!(grid[newFence.getX()][newFence.getY()] instanceof Fence)) {
				grid[newFence.getX()][newFence.getY()] = newFence;
			}
			else{
				i--;
			}
		}
	}
	public Fence initRandFence() {
		double y = Math.random()*10+1;
		double x =  Math.random()*10+1;

		return new Fence((int)x, (int)y);
	}
	public void initEnemies() {
		for(int i = 0; i < 12; i++)
	}
	public void initPlayer() {
		
	}

	
}
