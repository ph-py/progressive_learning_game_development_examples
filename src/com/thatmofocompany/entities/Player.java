package com.thatmofocompany.entities;

// Imports for Render
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Player {
	// Variables for Render
	public Spritesheet sheet;
	public BufferedImage[] player;
	
	// Variables for Tick
	public boolean right, left, up, down;
	public int x, y;
	public int curAnimation = 0;
	
	// Constructor
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		// Right and Left Walking
		if(right) {
			x++;
			if (curAnimation >= 3) {
				curAnimation = 0;
			}
			curAnimation++;
		}
		else if(left) {
			x--;
			if (curAnimation <= 3) {
				curAnimation = 4;
			}
			curAnimation++;
			if (curAnimation >= 8) {
				curAnimation = 4;
			}
		}
		
		// Right and Left Borders
		if(x > Example_3_Infinity_Loop_Tick.WIDTH - 16) {
			x = Example_3_Infinity_Loop_Tick.WIDTH - 16;
		}
		else if (x < 0) {
			x = 0;
		}
		
		// Up and Down Walking
		if(up) {
			y--;
		}
		else if(down) {
			y++;
		}
		
		// Up and Down Borders
		if(y > Example_3_Infinity_Loop_Tick.HEIGHT - 16) {
			y = Example_3_Infinity_Loop_Tick.HEIGHT - 16;
		}
		else if (y < 0) {
			y = 0;
		}
	}
	
	public void render(Graphics g) {
		sheet = new Spritesheet("/spritesheet.png");
		player = new BufferedImage[9];
		
		// Diferent types of animation on Spritesheet
		// Certainly could be better
		player[0] = sheet.getSprite(0, 0, 16, 16);
		player[1] = sheet.getSprite(16, 0, 16, 16);		
		player[2] = sheet.getSprite(32, 0, 16, 16);		
		player[3] = sheet.getSprite(48, 0, 16, 16);
		player[4] = sheet.getSprite(64, 0, 16, 16);
		player[5] = sheet.getSprite(80, 0, 16, 16);
		player[6] = sheet.getSprite(96, 0, 16, 16);
		player[7] = sheet.getSprite(112, 0, 16, 16);
		player[8] = sheet.getSprite(128, 0, 16, 16);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player[curAnimation], x, y, null);
	}
}
