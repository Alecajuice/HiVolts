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

		initCells();
		initBorders();
		initInsideFences();
		initEnemies();
		initPlayer();
	}
	
	public void paintComponent(Graphics g) {
		drawCells(g);
	}

	public void initCells() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				grid[i][j] = new Cell(i, j, this);
			}
		}
	}
	public void initBorders() {
		for(int i = 0; i < 12; i++) {
			grid[0][i] = new Fence(0, i, this);
			grid[11][i] = new Fence(11, i, this);
			
		}
		for(int i = 1; i <11; i++) {
			grid[i][0] = new Fence(i, 0, this);
			grid[i][11] = new Fence(i, 11, this);
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
		int y = (int) (Math.random()*10+1);
		int x =  (int) (Math.random()*10+1);

		return new Fence(x, y, this);
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
		int y = (int) (Math.random()*10+1);
		int x =  (int) (Math.random()*10+1);

		return new Mho(x, y, grid[x][y]);
	}
	public void initPlayer() {
		int y = (int) (Math.random()*10+1);
		int x =  (int) (Math.random()*10+1);
		Player player = new Player(x, y, grid[x][y]);
		if (!(grid[player.getX()][player.getY()] instanceof Fence) && !(grid[player.getX()][player.getY()].isOccupiedBy(Mho.class)))
			grid[player.getX()][player.getY()].occupy(player);
		else
			initPlayer();
	}
	
	public void drawCells(Graphics g) {
		for (int row = 0; row < 12; row++) {
			for (int col = 0; col < 12; col++) {
					grid[row][col].draw(25, 25, 50, 50, g);
				
			}
		}
	}

	public Player findPlayer() {
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell.isOccupiedBy(Player.class)) {
					try {
						return (Player)cell.getOccupant();
					} catch (Exception e) {
						System.err.println("Player not found.");
					}
				}
			}
		}
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
