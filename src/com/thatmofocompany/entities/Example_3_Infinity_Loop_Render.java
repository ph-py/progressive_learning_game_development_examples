package com.thatmofocompany.entities;

// Import for Canvas to be inherited
import java.awt.Canvas;
import java.awt.Color;

// Import JFrame for Create Window 
import javax.swing.JFrame;
import java.awt.Dimension;

// Import BufferedImage for Render
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Example_3_Infinity_Loop_Render extends Canvas implements Runnable {
	// Serialization for Java
	private static final long serialVersionUID = 1L;

	// Constructor
	public Example_3_Infinity_Loop_Render() {
		initFrame();
	}
	
	// Variables for Create Window
	private JFrame frame;
	private final int WIDTH = 240;
	private final int HEIGHT = 160;
	private final int SCALE = 3;
	
	public void initFrame() {
		frame = new JFrame("Game Infinity Loop - Render");
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Variables for Threads
	private Thread thread;
	private boolean isRunning = true;
	
	// Method start to call by Game object
	public synchronized void start() {
		// Thread(this) -> "this" to call for Method run()
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		// Interrupt Infinity Loop
		isRunning = false;
		try {
			System.out.println("Thread Stopped");
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Thread Started");
		// Infinity Loop
		while(isRunning) {
			System.out.println("Running");
			tick();
			render();
		}
		
		stop();
	}
	
	// Methods for Infinity Loop
	public void tick() {
		
	}
	
	// Variables for render()
	private BufferedImage image;
	
	public void render() {
		// Creates a buffer to drawn what you want
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		// Create a image and an object graphic 'g' to draw on that image
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		
		// Background - a white rectangle with the size of WIDTH and HEIGHT
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// Put the Object Graphic 'g' and pass to buffer to draw image, finally make BufferedStrategy 'bs' draw
		// Enlarge the size with scale
		// Draw mofo!
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		bs.show();
	}
	
	// Main
//	public static void main(String[] args) {
//		Example_3_Infinity_Loop_Render game = new Example_3_Infinity_Loop_Render();
//		game.start();
//	}
}
