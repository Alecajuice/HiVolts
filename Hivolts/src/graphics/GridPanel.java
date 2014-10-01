package graphics;

import entity.Cell;
import entity.Fence;
import entity.mob.Mho;
import entity.mob.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel {
	
	private Gui gui;
	private int width;
	private int height;
	
	//height and width -2, compensates for fence boundaries
	private int w;
	private int h;
	private Cell[][] grid;
		public Cell[][] getGrid() {return grid;}

	public GridPanel(int width, int height, Gui gui) {
		this.height = height;
		this.width = width;
		this.gui = gui;
		
		this.h = height-2;
		this.w = width-2;
		
		grid = new Cell[width][height];
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
		if(gui.getRekt()) {
			g.setFont(g.getFont().deriveFont(100f).deriveFont(Font.BOLD));
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 25 + (this.width*50 - g.getFontMetrics().stringWidth("GAME OVER"))/2, 25 + (int) ((this.height*50 - g.getFontMetrics().getStringBounds("GAME OVER", g).getHeight())/2));
		}
		if(gui.getSweg()) {
			g.setFont(g.getFont().deriveFont(100f).deriveFont(Font.BOLD));
			g.setColor(Color.GREEN);
			g.drawString("YOU WIN", 25 + (this.width*50 - g.getFontMetrics().stringWidth("YOU WIN"))/2, 25 + (int) ((this.height*50 - g.getFontMetrics().getStringBounds("YOU WIN", g).getHeight())/2));
		}
	}
	/**
	 * 
	 * @return Returns height of game board excluding fence border
	 */
	public int getH() {
		return this.h;
	}
	
	/**
	 * 
	 * @return Returns width of game board excluding fence border
	 */
	public int getW() {
		return this.w;
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
			grid[width-1][i] = new Fence(width-1, i, this);
		}
		//Offset by 1 because corner
		for(int i = 1; i < width; i++) {
			grid[i][0] = new Fence(i, 0, this);
			grid[i][height-1] = new Fence(i, height-1, this);
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
		int x =  (int) (Math.random()*w+1);
		int y = (int) (Math.random()*h+1);

		return new Fence(x, y, this);
	}
	private void initEnemies() {
		for(int i = 0; i < 12; i++) {
			Mho newEnemy = initRandMho(i);
			if(!(grid[newEnemy.getX()][newEnemy.getY()] instanceof Fence) && !(grid[newEnemy.getX()][newEnemy.getY()].contains(Mho.class))) {
				grid[newEnemy.getX()][newEnemy.getY()].occupy(newEnemy);
			}
			else{
				i--;
			}
		}
	}
	private Mho initRandMho(int i) {
		int x =  (int) (Math.random()*w+1);
		int y = (int) (Math.random()*h+1);

		return new Mho(x, y, grid[x][y], i);
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
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
					grid[row][col].draw(25, 35, 50, 50, g);
				
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
				}
			}
		}
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell.contains(Mho.class)) {
					((Mho) cell.getOccupant()).moved = false;
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
