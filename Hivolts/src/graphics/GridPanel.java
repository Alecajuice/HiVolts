package graphics;

import entity.Cell;
import entity.mob.Mho;
import entity.mob.Player;

import java.awt.*;

import javax.swing.*;

//One game grid
public class GridPanel extends JPanel {

	private int height;
	private int width;
	private Cell[][] grid = new Cell[12][12];

	public GridPanel(int width, int height) {
		this.height = height;
		this.width = width;

		this.setSize(width, height);
	}

	public Player findPlayer() {
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell instanceof Player) {
					return (Player) cell;
				}
			}
		}
		System.err.println("Player not found.");
		return null;
	}

	public void nextTurn() {
		for (Cell[] c : grid) {
			for (Cell cell : c) {
				if (cell instanceof Mho) {
					((Mho) cell).ai();
				}
			}
		}
	}
}
