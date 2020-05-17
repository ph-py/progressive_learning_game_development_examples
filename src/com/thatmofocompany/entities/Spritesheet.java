package com.thatmofocompany.entities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {
	
	// Variavel do tipo BufferedImage
	private BufferedImage spritesheet;
	
	// Constructor
	public Spritesheet(String path) {
		try {
			spritesheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	// metódo retorna o spritesheet para o update do Game
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
