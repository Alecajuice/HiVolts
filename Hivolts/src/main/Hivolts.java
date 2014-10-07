package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Cell;
import entity.Fence;
import graphics.GridPanel;
import graphics.Gui;
/*AUTHORS*/
//Alex Tarng, Nihar Mitra, James Ngo, Ailyn Tong

//This is the main class for Hivolts. The main creates a Gui where the player can move around and interact with elements in the game
//The controls are q,w,e,a,s,d,z,x,c or the numpad. If you want to jump press j. 

//You are Rafi (guy with laser eyes)
//The Mhos are Tyler (yellow cars)
//The Fences are Mr. Kuszmaul

/*
 * Goals:
 * make a two player game
 */
public class Hivolts {
	public static void main(String[] args) {
		//Pass width and height of the game board
		//Also passes the existence of a second player
		//initializes the pictures for the game
		try
		{
		    Fence.img = ImageIO.read(new File("res/img/Kuszmaul.jpg"));
		    GridPanel.lab = ImageIO.read(new File("res/img/lab.jpg"));
		} catch (IOException e)
		{
		}
		Gui gui = new Gui(false, 12, 12, 0, 0);
	}
}
