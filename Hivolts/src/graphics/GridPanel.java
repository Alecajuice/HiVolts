package graphics;

import entity.Cell;
import entity.Fence;
import entity.mob.Mho;
import entity.mob.Player;

import java.awt.*;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel {

	private int height;
	private int width;
	private Cell[][] grid = new Cell[12][12];
		public Cell[][] getGrid() {return grid;}

	public GridPanel(int width, int height) {
		this.height = height;
		this.width = width;

		this.setSize(width, height);
		initAllCells();
	}
	
	public void initAllCells() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				grid[i][j] = new Cell(i, j);
			}
		}
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
		for(int i = 0; i < 12; i++) {
			Mho newEnemy = initRandMho();
			if(!(grid[newEnemy.getX()][newEnemy.getY()] instanceof Fence) && !(grid[newEnemy.getX()][newEnemy.getY()].isOccupiedBy(Mho.class))) {
				grid[newEnemy.getX()][newEnemy.getY()].occupy(newEnemy);
			}
			else{
				i--;
			}
		}
	}
	public Mho initRandMho() {
		double y = Math.random()*10+1;
		double x =  Math.random()*10+1;

		return new Mho((int)x, (int)y);
	}
	public void initPlayer() {
		double y = Math.random()*10+1;
		double x =  Math.random()*10+1;

		Player player = new Player((int)x, (int)y);
		if(!(grid[player.getX()][player.getY()] instanceof Fence) && !(grid[player.getX()][player.getY()].isOccupiedBy(Mho.class)))grid[player.getX()][player.getY()].occupy(player);
		else initPlayer();
	}

	public Player findPlayer() {
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell.isOccupiedBy(Player.class)) {
					return (Player)cell.getOccupant();
				}
			}
		}
		System.err.println("Player not found.");
		return null;
	}

	public void nextTurn() {
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell.isOccupiedBy(Mho.class)) {
					((Mho)cell.getOccupant()).ai();
				}
			}
		}
	}
	
	public Cell getCell(int x, int y) {
		return grid[x][y];
	}
}
