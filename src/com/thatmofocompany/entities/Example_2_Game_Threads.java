package com.thatmofocompany.entities;

// Import for Canvas to be inherited
import java.awt.Canvas;

// Import for Create Object JFrame
import javax.swing.JFrame;
import java.awt.Dimension;

public class Example_2_Game_Threads extends Canvas implements Runnable {
	// Java Serialization
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Example_2_Game_Threads() {
		System.out.println("Creating Window!");
		initFrame();
		
	}
	
	// Variables for Create Window
	public static JFrame frame;
	private final int WIDTH = 240;
	private final int HEIGHT = 160;
	private final int SCALE = 3;
	
	// Method for Create Window
	private void initFrame() {
		frame = new JFrame("Game Threads");
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.setResizable(false);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	// Variables for Thread
	private Thread thread;
	private boolean isRunning = true;
	
	@Override
	public void run() {
		System.out.println("Thread Started");
		stop();
	}
	
	// Method for Thread start on Main()
	public synchronized void start() {
		// Thread(this) -> "this" to call for Method run()
		thread = new Thread(this);
		thread.start();
	}
	
	// Method for Thread stop
	public synchronized void stop() {
		isRunning = false;
		try {
			System.out.println("Thread Stopped");
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Main
//	public static void main(String[] args) {
//		Example_2_Game_Threads game = new Example_2_Game_Threads();
//		game.start();
//	}
//	
}
