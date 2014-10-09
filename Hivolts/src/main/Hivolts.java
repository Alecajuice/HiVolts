package main;

/*AUTHORS*/

//Alex Tarng, Nihar Mitra, James Ngo, Ailyn Tong



//FOR CLARIFYING PURPOSES
//You are Rafi (guy with laser eyes, not the background though)
//The Fences are Mr. Kuszmaul
//The Mhos are everything else

/*
 * Goals:
 * Make a two player game
 * Add Main Menu
 */

/*
 * Timeline:
 * 	First few days:
 *   Framework and Inheritance hierarchy with Cells
 *   Finished Initializing mhos and cells in correct places
 *  After check in:
 *   Finished moving 
 *   Finished Mho AI
 *   Finished basic drawing based upon original game and Conway code\
 *  Final touches:
 *   Implemented Images
 *   Fixed Images and painting
 *   
 */

/*
 * Controls:
 * Q & 7 = upleft
 * W & 8 = up
 * E & 9 = upright
 * A & 4 = left
 * S & 5 = Sit
 * D & 6 = Right
 * Z & 1 = downleft
 * X & 2 = down 
 * C & 3 = downright
 * R = Restart game
 */

/* 
 * Acknowledgments: 
 * Mr. Kuszmaul's Conway code for the draw methods
 *Introduction to Java Programming by Y. Daniel Liang to help us with generics
 *Github and friends for the images
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
		/*
		 * Main class:
		 * This is the main class for Hivolts. The main creates a Gui where the player can move around and interact with elements in the game.
		 * It also imports pictures for the game elements in the try and catch.
		 */
		try {
			Fence.img = ImageIO.read(new File("res/img/Kuszmaul.jpg"));
			GridPanel.lab = ImageIO.read(new File("res/img/EverythingIsTyler.png"));
		} catch (IOException e) {
		}
		Gui gui = new Gui(false, 12, 12, 0, 0);
	}
}


