
//Gui class
/* The grid and restart button are initialized here, along with the win/lose system.
 * The typing mechanic (KeyListener) is also defined here.
 */

package graphics;

//imports
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame implements KeyListener {
	private static int WIDTH;
	private static int HEIGHT;
	private static int rows = 12;
	private static int cols = 12;
	private boolean p2 = false;
	private GridPanel grid;
	private RestartButton restart;
	private boolean lose = false;
	private boolean win = false;

	//constructor, creates new Gui which contains all game elements inside
	/*parameters: 
		boolean that determines one/two player mode
		ints for # rows and cols 
		ints for width and height of the Gui
		*/
	public Gui(boolean twoPlayer, int x, int y, int width, int height) {
		super("Hivolts");
		p2 = twoPlayer;
		if(width == 0 || height == 0) {
			WIDTH = x*50 + 100;
			HEIGHT = y*50 + 100;
		}
		else {
			WIDTH = width;
			HEIGHT = height;
		}
		rows = x;
		cols = y;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		grid = new GridPanel(twoPlayer, x, y, this);
		add(grid);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addKeyListener(this);
	}
	
	//returns GridPanel
	public GridPanel getGrid() {
		return grid;
	}
	//returns lose
	public boolean getLose() {
		return lose;
		}
	//returns win
	public boolean getWin() {
		return win;
		}

	// Unused
	@Override
	public void keyTyped(KeyEvent e) {
	}
	/* If a key is pressed, moves players accordingly. Calls nextTurn() to make
	 * Mhos move
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (!lose && !win) {
			int c = e.getKeyCode();
			//Uses switch case falling to do the same thing for different inputs
			switch (c) {
			case KeyEvent.VK_Q:
			case KeyEvent.VK_7:
			case KeyEvent.VK_NUMPAD7:
				grid.findPlayer().move(-1, -1);
				grid.nextTurn();
				break;
			case KeyEvent.VK_W:
			case KeyEvent.VK_8:
			case KeyEvent.VK_NUMPAD8:
			case KeyEvent.VK_UP:
				grid.findPlayer().move(0, -1);
				grid.nextTurn();
				break;
			case KeyEvent.VK_E:
			case KeyEvent.VK_9:
			case KeyEvent.VK_NUMPAD9:
				grid.findPlayer().move(1, -1);
				grid.nextTurn();
				break;
			case KeyEvent.VK_A:
			case KeyEvent.VK_4:
			case KeyEvent.VK_NUMPAD4:
			case KeyEvent.VK_LEFT:
				grid.findPlayer().move(-1, 0);
				grid.nextTurn();
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_5:
			case KeyEvent.VK_NUMPAD5:
				grid.nextTurn();
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_6:
			case KeyEvent.VK_NUMPAD6:
			case KeyEvent.VK_RIGHT:
				grid.findPlayer().move(1, 0);
				grid.nextTurn();
				break;
			case KeyEvent.VK_Z:
			case KeyEvent.VK_1:
			case KeyEvent.VK_NUMPAD1:
				grid.findPlayer().move(-1, 1);
				grid.nextTurn();
				break;
			case KeyEvent.VK_X:
			case KeyEvent.VK_2:
			case KeyEvent.VK_NUMPAD2:
			case KeyEvent.VK_DOWN:
				grid.findPlayer().move(0, 1);
				grid.nextTurn();
				break;
			case KeyEvent.VK_C:
			case KeyEvent.VK_3:
			case KeyEvent.VK_NUMPAD3:
				grid.findPlayer().move(1, 1);
				grid.nextTurn();
				break;
			case KeyEvent.VK_J:
			case KeyEvent.VK_0:
			case KeyEvent.VK_NUMPAD0:
			case KeyEvent.VK_SPACE:
				grid.findPlayer().jump();
				break;
			case KeyEvent.VK_R:
				restart();
				break;
			}
			grid.repaint();
		}
	}
	//Unused
	@Override
	public void keyReleased(KeyEvent e) {
	}

	 /*if player wins/loses draws correct message over board, freezes game, and
	  *draws restart button
	  */	
	public void gameOver() {
		this.lose = true;
		grid.repaint();
		drawButton();
	}
	//if player wins draws correct message over board, freezes game, and draws restart button
	public void win() {
		this.win = true;
		grid.repaint();
		drawButton();
	}

	//creates a new Restart Button
	private void drawButton() {
		restart = new RestartButton();
		restart.setBounds(0, 0, 100, 36);
		add(restart);
		restart.setVisible(true);
		restart.repaint();
	}

	//deletes old instance of class and creates new instance
	public void restart() {
		this.dispose();
		System.out.println(this.getWidth() +", " + this.getHeight());
		new Gui(p2, rows, cols, this.getWidth(), this.getHeight());
	}

	//Restart Button
	private class RestartButton extends JButton implements ActionListener {
		RestartButton() {
			super("Restart");
			addActionListener(this);
		}
		public void actionPerformed(ActionEvent arg0) {
			restart();
		}
	}
}
