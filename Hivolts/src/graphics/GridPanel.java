package graphics;

import entity.Cell;
import entity.Fence;
import entity.mob.Mho;
import entity.mob.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel {
	public static BufferedImage lab;
	private Gui gui;
	private int width;
	private int height;
	private int cellWidth = 50;
	private int cellHeight = 50;
	double scale;
	// 2 player game or not
	private boolean p2;
	private boolean background = false;

	//height and width -2, compensates for fence boundaries
	private int w;
	private int h;
	private Cell[][] grid;
	public Cell[][] getGrid() {return grid;}

	//constructor, creates grid and all cells
	public GridPanel(boolean twoPlayer, int width, int height, Gui gui) {
		this.height = height;
		this.width = width;
		this.gui = gui;

		this.p2 = twoPlayer;
		this.h = height-2;
		this.w = width-2;

		grid = new Cell[width][height];
		initAllCells();
	}

	//returns Gui
	public Gui getGui() {
		return this.gui;
	}

	//initializes everything
	public void initAllCells() {
		initCells();
		initBorders();
		initInsideFences();
		initEnemies();
		initPlayer(1);
		if(p2) {
			initPlayer(2);
		}
	}

	//draws everything and scales the frame
	public void paintComponent(Graphics g) {
		setScale();	//makes the grid scale according to panel size
		if(!background) {
			g.drawImage(Player.getImage(), 25, 35, (cellWidth+1)*this.width+1, (cellHeight+1)*this.height+1, null);
			background = true;
		}
		g.setColor(Color.CYAN);
		drawCells(g); 
		if(gui.getRekt()) {		//if lose displays a GAME OVER message
			g.setFont(g.getFont().deriveFont(100f).deriveFont(Font.BOLD));
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 25 + ((cellWidth+1)*this.width+1 - g.getFontMetrics().stringWidth("GAME OVER"))/2, 25 + (int) (((cellHeight+1)*this.height+1 - g.getFontMetrics().getStringBounds("GAME OVER", g).getHeight())/2));
		}
		if(gui.getSweg()) {		//if win displays a YOU WIN message
			g.setFont(g.getFont().deriveFont(100f).deriveFont(Font.BOLD));
			g.setColor(Color.GREEN);
			g.drawString("YOU WIN", 25 + ((cellWidth+1)*this.width+1 - g.getFontMetrics().stringWidth("YOU WIN"))/2, 25 + (int) (((cellHeight+1)*this.height+1 - g.getFontMetrics().getStringBounds("YOU WIN", g).getHeight())/2));
		}
	}
	
	//Returns height of game board excluding fence border
	public int getH() {
		return this.height;
	}

	//Returns width of game board excluding fence border
	public int getW() {
		return this.width;
	}

	//initializes all cells
	private void initCells() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				grid[i][j] = new Cell(i, j, this);
			}
		}
	}
	//inits border cells with type Fence
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
	//inits 20 random cells with type Fence, makes sure that they are in different spots
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
	//creates a Fence at a random location within border Fences
	private Fence initRandFence() {
		int x =  (int) (Math.random()*w+1);
		int y = (int) (Math.random()*h+1);

		return new Fence(x, y, this);
	}
	//inits 12 Mhos that are in different places from fences and other mhos
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
	//creates a Mho at a random location within border Fences
	private Mho initRandMho(int i) {
		int x =  (int) (Math.random()*w+1);
		int y = (int) (Math.random()*h+1);

		return new Mho(x, y, grid[x][y], i);
	}
	//inits a Player at a random location (not on Fence or Mho)
	private void initPlayer(int playerNum) {
		int x =  (int) (Math.random()*(width-1));
		int y = (int) (Math.random()*(height-1));
		Player player = new Player(x, y, grid[x][y]);
		if (!(grid[player.getX()][player.getY()] instanceof Fence) && !(grid[player.getX()][player.getY()].contains(Mho.class)))
			grid[player.getX()][player.getY()].occupy(player);
		else
			initPlayer(playerNum);
	}
	//draws cells
	public void drawCells(Graphics g) {
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				grid[row][col].draw(25, 35, cellWidth, cellHeight, g);

			}
		}
	}
	//returns the cell that holds the player. If player not found returns null
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
	//returns cell that holds player2. If player2 nto found returns null
	public Player findPlayer2() {
		if(!p2) {
			return null;
		}
		else {
			for(Cell[] c : grid) {
				for(Cell cell : c) {
					if (cell.contains(Player.class)) {
						try {
							if((Player)cell.getOccupant() == findPlayer()) {
								continue;
							}
							else {
								return (Player) cell.getOccupant();
							}
						} catch (Exception e) {
							System.err.println("Player not found.");
						}
					}
				}
			}
		}
		return null;
	}
	//calculates how Mhos should move
	public void nextTurn() {
		boolean allDead = true;
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell.contains(Mho.class)) {
					Mho mho = (Mho) cell.getOccupant();
					if(!p2) {
						mho.ai(this.findPlayer());
					}
					//In 2 player, moves towards closer target
					else {
						double p1Distance = mho.distanceTo(findPlayer().getX(), findPlayer().getY());
						double p2Distance = mho.distanceTo(findPlayer2().getX(), findPlayer2().getY());
						if(p1Distance == p2Distance) {
							if(Math.random() <= 0.5) {
								mho.ai(findPlayer());
							}
							else {
								mho.ai(findPlayer2());
							}
						}
						else if(p1Distance < p2Distance) {
							mho.ai(findPlayer());
						}
						else {
							mho.ai(findPlayer2());
						}
					}
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
		if(allDead) {	//if all Mhos dead player wins
			this.gui.win();
		}
	}
	//returns a Cell
	public Cell getCell(int x, int y) {
		return grid[x][y];
	}
	//sets the scale of grid and everything withing according to panel size
	public void setScale() {
		w = getWidth();
		h = getHeight();
		cellWidth = (w-100)/width;
		cellHeight = (h-100)/height;
	}
}
