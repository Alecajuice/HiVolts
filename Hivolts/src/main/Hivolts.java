package main;

/*AUTHORS*/
//Alex Tarng, Nihar Mitra, James Ngo, Ailyn Tong

//This is the main class for Hivolts. The main creates a Gui where the player can move around and interact with elements in the game

//FOR CLARIFYING PURPOSES
//You are Rafi (guy with laser eyes)
//The Fences are Mr. Kuszmaul
//The Mhos are everything else

/*
 * Goals:
 * Make a two player game
 * Add Main Menu and Statistics
 */

/*
 * Controls:
 * Numpad is supported.
 * Q & 7 = up-left
 * W & 8 = up
 * E & 9 = up-right
 * A & 4 = left
 * S & 5 = Sit
 * D & 6 = Right
 * Z & 1 = down-left
 * X & 2 = down 
 * C & 3 = down-right
 * J and Spacebar = Jump
 * R and Restart = Restart game
 */

/* 
 * Decisions made:
 * Instead of using an array to store all the various elements of the grid, we decided to use a method
 * 		in which each element of the grid was an entity
 * The hierarchy of Entity is as such:
 * 		Cells: represent each grid space, have x, y and instance variable of what is contained by the cell
 * 		Fences extend Cell: represent electric fences, destroy all mobs that enter
 * 		Mob: an abstract class for mobile entities that are in a grid but not a stationary cell. Has an
 * 			instance variable that points to the container cell.
 * 		Mho extends Mob: represents the Mhos
 * 		Player extends Mob: represents the player
 */

/*
 * Timeline:
 * 	First few days:
 *   Framework and Inheritance hierarchy with Cells
 *   Finished Initializing mhos and cells in correct places
 *  After check in:
 *   Finished player movement
 *   Finished Mho AI
 *   Finished basic drawing based upon original game and Conway code
 *  Final touches:
 *   Implemented Images
 *   Fixed Images and painting
 *   
 *  Lots of debugging happened throughout; with each new change there were new bugs to solve
 */

/*
 * Problems encountered with code:
 * Player dying randomly
 * Mhos would search for player postmortem
 * Repaint not happening after each movement; Mhos and players would leave behind images
 */

/*
 * Problems encountered outside of code:
 * Difficulties using git, mostly merge errors
 * Communication problems, not talking about what we were going to do
 */

/* 
 * Acknowledgments: 
 * Mr. Kuszmaul's Conway code for the draw methods
 *Introduction to Java Programming by Y. Daniel Liang to help us with generics
 *These pictures are used with the permissions of:
 *Neelay Junnarkar
 *Tyler Packard
 *Alex Tarng
 *Nihar Mitra
 *James Ngo
 *Ben Cohen-Wang
 *Rafi Long
 *We do not own the contents of any of the profile pictures
 */

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Cell;
import entity.Fence;
import graphics.GridPanel;
import graphics.Gui;

public class Hivolts {
	/*
	 * Main class:
	 * This is the main class for Hivolts. The main creates a Gui where the player can move around and interact with elements in the game.
	 * It also imports pictures for the game elements in the try and catch.
	 */
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
