package main;

/*AUTHORS*/
//Alex Tarng, Nihar Mitra, James Ngo, Ailyn Tong

//This is the main class for Hivolts. The main creates a Gui where the player can move around and interact with elements in the game
//The controls are q,w,e,a,s,d,z,x,c or the numpad. If you want to jump press j. 

//FOR CLARIFYING PURPOSES
//You are Rafi (guy with laser eyes)
//The Fences are Mr. Kuszmaul
//The Mhos are everything else

/*
 * Goals:
 * make a two player game
 */

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Cell;
import entity.Fence;
import graphics.GridPanel;
import graphics.Gui;

public class Hivolts {
	public static void main(String[] args) {
		// Pass width and height of the game board
		// Also passes the existence of a second player
		// initializes the pictures for the game
		try {
			Fence.img = ImageIO.read(new File("res/img/Kuszmaul.jpg"));
			GridPanel.lab = ImageIO.read(new File("res/img/EverythingIsTyler.png"));
		} catch (IOException e) {
		}
		Gui gui = new Gui(false, 12, 12, 0, 0);
	}
}

//Acknowledgments: 
//Mr. Kuszmaul's Conway code for the draw methods
//Introduction to Java Programming by Y. Daniel Liang to help us with generics
//Github and friends for the images
