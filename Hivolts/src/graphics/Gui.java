package graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

//Main Gui class

public class Gui extends JFrame implements KeyListener
{
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	public Gui()
	{
		super("Hivolts");
		setSize(WIDTH, HEIGHT);
		GridPanel grid = new GridPanel(WIDTH, HEIGHT);
		add(grid);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		switch (c)
		{
		case KeyEvent.VK_Q:
			
			break;
		case KeyEvent.VK_W:
			
			break;
		case KeyEvent.VK_E:
			
			break;
		case KeyEvent.VK_A:
			
			break;
		case KeyEvent.VK_S:
			
			break;
		case KeyEvent.VK_D:
			
			break;
		case KeyEvent.VK_Z:
			
			break;
		case KeyEvent.VK_X:
			
			break;
		case KeyEvent.VK_C:
			
			break;
		case KeyEvent.VK_J:
			
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
