package graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Main Gui class

public class Gui extends JFrame implements KeyListener {
	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private GridPanel grid;

	public Gui(int x, int y) {
		super("Hivolts");
		setSize(WIDTH, HEIGHT);
		grid = new GridPanel(x, y, this);
		add(grid);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
	}

	public GridPanel getGrid() {
		return grid;
	}

	// Unused
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		switch (c) {
		case KeyEvent.VK_Q:
			grid.findPlayer().move(-1, -1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_W:
			grid.findPlayer().move(0, -1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_E:
			grid.findPlayer().move(1, -1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_A:
			grid.findPlayer().move(-1, 0);
			grid.nextTurn();
			break;
		case KeyEvent.VK_S:
			grid.nextTurn();
			break;
		case KeyEvent.VK_D:
			grid.findPlayer().move(1, 0);
			grid.nextTurn();
			break;
		case KeyEvent.VK_Z:
			grid.findPlayer().move(-1, 1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_X:
			grid.findPlayer().move(0, 1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_C:
			grid.findPlayer().move(1, 1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_J:
			grid.findPlayer().jump();
			grid.nextTurn();
			break;
		}
		grid.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void gameOver() {
		JFrame overFrame = new JFrame();
		overFrame.setSize(200, 100);
		overFrame.setVisible(true);
		overFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		overFrame.add(new JLabel("Game over."));
	}
	
	public void win() {
		JFrame overFrame = new JFrame();
		overFrame.setSize(200, 100);
		overFrame.setVisible(true);
		overFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		overFrame.add(new JLabel("You won!"));
	}
}
