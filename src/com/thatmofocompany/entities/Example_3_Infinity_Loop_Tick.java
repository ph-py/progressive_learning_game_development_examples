package com.thatmofocompany.entities;

// Import for Canvas to be inherited
import java.awt.Canvas;

// Import for Create Window
import javax.swing.JFrame;
import java.awt.Dimension;

// Import for Render
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Color;

// Import for Tick
import java.awt.event.KeyListener;


public class Example_3_Infinity_Loop_Tick extends Canvas implements Runnable, KeyListener {
	// Java Serialization
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public Example_3_Infinity_Loop_Tick() {
		initFrame();
		this.addKeyListener(this);
		player = new Player(100, 20);
	}
	
	// CREATE WINDOW
	
	// Variable for JFrame create window
	private JFrame frame;
	public static int WIDTH = 240;
	public static int HEIGHT = 160;
	public static int SCALE = 3;
	
	// Create Window
	public void initFrame() {
		frame = new JFrame("Game Infinity Loop - Tick");
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	// THREADS 
	
	// Variables for Threads
	private Thread thread;
	private boolean isRunning = true;
	
	// Method for Thread could be started on main()
	public synchronized void start() {
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
	
	@Override
	public void run() {
		System.out.println("Thread started");
		// Infinity Loop
		while(isRunning) {
			System.out.println("Running");
			tick();
			render();
			// Framerate setted to 60 FPS
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		stop();
	}
	
	// INFINITY LOOP
	
	// Variable for Render & Tick Player
	private Player player;
	
	// Variables for Render
	private BufferedImage image; 
	
	// Method for Render on screen
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		player.render(g);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		bs.show();
	}
	
	public void tick() {
		player.tick();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}
	
	public static void main(String[] args) {
		Example_3_Infinity_Loop_Tick game = new Example_3_Infinity_Loop_Tick();
		game.start();
	}
}
