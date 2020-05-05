package com.thatmofocompany.entities;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Example_1_Game_Window extends Canvas {
	
	// Serialization
	private static final long serialVersionUID = 1L;
	
	// Variables for create window
	public static JFrame frame;
	private final int WIDTH = 240;
	private final int HEIGHT = 160;
	private final int SCALE = 3;
	
	// Constructor
	public Example_1_Game_Window() {
		initFrame();
	}
	
	// Main
	public static void main(String[] args) {
		Example_1_Game_Window game = new Example_1_Game_Window();
	}
	
	public void initFrame() {
		// Create frame object for window
		// Configure Window Dimensions
		// Configure close option
		frame = new JFrame("PH's game");
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Put the frame on window
		// Adds the "frame" Container into the window itself
		// Remove the resize option
		frame.add(this);
		frame.setResizable(false);
		
		// Display the window
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}