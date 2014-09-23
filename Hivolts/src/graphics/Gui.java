package graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

//Main Gui class

public class Gui extends JFrame implements KeyListener {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private GridPanel grid;

	public Gui() {
		super("Hivolts");
		setSize(WIDTH, HEIGHT);
		grid = new GridPanel(WIDTH, HEIGHT);
		add(grid);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
	}

	//Unused
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		switch (c) {
		case KeyEvent.VK_Q:
			grid.findPlayer().move(-1, 1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_W:
			grid.findPlayer().move(0, 1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_E:
			grid.findPlayer().move(1, 1);
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
			grid.findPlayer().move(-1, -1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_X:
			grid.findPlayer().move(0, -1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_C:
			grid.findPlayer().move(1, -1);
			grid.nextTurn();
			break;
		case KeyEvent.VK_J:
			grid.findPlayer().jump();
			grid.nextTurn();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
