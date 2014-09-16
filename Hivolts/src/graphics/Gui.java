package graphics;

import javax.swing.JFrame;

//Main Gui class

public class Gui extends JFrame 
{


	public Gui(int width, int height) 
	{
		super("Hivolts");
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
