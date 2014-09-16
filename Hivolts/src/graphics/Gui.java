package graphics;

import javax.swing.JFrame;

//Main Gui class

public class Gui {
	public Gui() {
		JFrame frame = new JFrame();
		frame.add(new GridPanel());
	}
}
