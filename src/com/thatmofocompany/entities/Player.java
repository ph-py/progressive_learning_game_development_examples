package com.thatmofocompany.entities;

// Imports for Render
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Player {
	// Variables for Render
	private Spritesheet sheet;
	private BufferedImage[] player;
	
	// Variables for Tick
	public boolean right, left, up, down;
	private int x, y;
	private int curAnimation = 0;
	
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
			if (curAnimation <= 4) {
				curAnimation = 4;
			}
			curAnimation++;
			if (curAnimation > 7) {
				curAnimation = 4;
			}
		}
		
		// Up and Down Walking
		if(up) {
			y--;
			if (right) {
				if (curAnimation >= 3) {
					curAnimation = 0;
				}
				curAnimation++;
			}
			else if (left) {
				if (curAnimation <= 4) {
					curAnimation = 4;
				}
				curAnimation++;
				if (curAnimation > 7) {
					curAnimation = 4;
				}
			}
			else {
				if (curAnimation <= 8) {
					curAnimation = 8;
				}
				curAnimation++;
				if (curAnimation > 11) {
					curAnimation = 8;
				}
			}
		}
		else if(down) {
			y++;
			if (right) {
				if (curAnimation >= 3) {
					curAnimation = 0;
				}
				curAnimation++;
			}
			else if (left) {
				if (curAnimation <= 4) {
					curAnimation = 4;
				}
				curAnimation++;
				if (curAnimation > 7) {
					curAnimation = 4;
				}
			}
			else {
				if (curAnimation <= 12) {
					curAnimation = 12;
				}
				curAnimation++;
				if (curAnimation > 15) {
					curAnimation = 12;
				}
			}
		}
		
		// Right and Left Borders
		if(x > Example_3_Infinity_Loop_Tick.WIDTH - 16) {
			x = Example_3_Infinity_Loop_Tick.WIDTH - 16;
		}
		else if (x < 0) {
			x = 0;
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
		player = new BufferedImage[16];
		
		// Diferent types of animation on Spritesheet
		// Certainly could be better
		// Right
		player[0] = sheet.getSprite(0, 0, 16, 16);
		player[1] = sheet.getSprite(16, 0, 16, 16);		
		player[2] = sheet.getSprite(32, 0, 16, 16);		
		player[3] = sheet.getSprite(48, 0, 16, 16);
		// Left
		player[4] = sheet.getSprite(64, 0, 16, 16);
		player[5] = sheet.getSprite(80, 0, 16, 16);
		player[6] = sheet.getSprite(96, 0, 16, 16);
		player[7] = sheet.getSprite(112, 0, 16, 16);
		// Down
		player[8] = sheet.getSprite(0, 16, 16, 16);
		player[9] = sheet.getSprite(16, 16, 16, 16);
		player[10] = sheet.getSprite(32, 16, 16, 16);
		player[11] = sheet.getSprite(48, 16, 16, 16);
		// Up
		player[12] = sheet.getSprite(64, 16, 16, 16);
		player[13] = sheet.getSprite(80, 16, 16, 16);
		player[14] = sheet.getSprite(96, 16, 16, 16);
		player[15] = sheet.getSprite(112, 16, 16, 16);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(player[curAnimation], x, y, null);
		
	}
}
