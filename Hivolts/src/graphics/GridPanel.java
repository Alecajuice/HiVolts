package graphics;

import entity.Cell;
import entity.Fence;
import entity.mob.Mho;
import entity.mob.Player;

import java.awt.*;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel {

	private Gui gui;
	private int height;
	private int width;
	private Cell[][] grid = new Cell[12][12];
		public Cell[][] getGrid() {return grid;}

	public GridPanel(int width, int height, Gui gui) {
		this.height = height;
		this.width = width;
		this.gui = gui;
		
		this.setSize(width, height);
		initAllCells();
	}

	public Gui getGui() {
		return this.gui;
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

	private void initCells() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				grid[i][j] = new Cell(i, j, this);
			}
		}
	}
	private void initBorders() {
		for(int i = 0; i < height; i++) {
			grid[0][i] = new Fence(0, i, this);
			grid[width-1][i] = new Fence(11, i, this);
			
		}
		for(int i = 1; i < width; i++) {
			grid[i][0] = new Fence(i, 0, this);
			grid[i][height-1] = new Fence(i, 11, this);
		}
	}
	private void initInsideFences() {
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
	private Fence initRandFence() {
		int y = (int) (Math.random()*10+1);
		int x =  (int) (Math.random()*10+1);

		return new Fence(x, y, this);
	}
	private void initEnemies() {
		for(int i = 0; i < 12; i++) {
			Mho newEnemy = initRandMho();
			if(!(grid[newEnemy.getX()][newEnemy.getY()] instanceof Fence) && !(grid[newEnemy.getX()][newEnemy.getY()].contains(Mho.class))) {
				grid[newEnemy.getX()][newEnemy.getY()].occupy(newEnemy);
			}
			else{
				i--;
			}
		}
	}
	private Mho initRandMho() {
		int y = (int) (Math.random()*10+1);
		int x =  (int) (Math.random()*10+1);

		return new Mho(x, y, grid[x][y]);
	}
	private void initPlayer() {
		int x =  (int) (Math.random()*(width-1));
		int y = (int) (Math.random()*(height-1));
		Player player = new Player(x, y, grid[x][y]);
		if (!(grid[player.getX()][player.getY()] instanceof Fence) && !(grid[player.getX()][player.getY()].contains(Mho.class)))
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
				if (cell.contains(Player.class)) {
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
		boolean allDead = true;
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell.contains(Mho.class)) {
					((Mho) cell.getOccupant()).ai();
					allDead = false;
				}
			}
		}
		if(allDead) {
			this.gui.win();
		}
	}
	
	public Cell getCell(int x, int y) {
		return grid[x][y];
	}
}
