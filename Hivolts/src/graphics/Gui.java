package graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

//Main Gui class

public class Gui extends JFrame implements KeyListener
{
	public Gui(int width, int height)
	{
		super("Hivolts");
		setSize(width, height);
		GridPanel grid = new GridPanel(width, height);
		add(grid);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		case KeyEvent.VK_W:
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
