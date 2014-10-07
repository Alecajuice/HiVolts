package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Cell;
import entity.Fence;
import graphics.GridPanel;
import graphics.Gui;

public class Main {
	public static void main(String[] args) {
		//Pass width and height of the game board
		//Also passes the existence of a second player
		try
		{
		    Fence.img = ImageIO.read(new File("res/img/Kuszmaul.jpg"));
		    GridPanel.lab = ImageIO.read(new File("res/img/lab.jpg"));
		} catch (IOException e)
		{
		}
		Gui gui = new Gui(false, 12, 12);
	}
}
