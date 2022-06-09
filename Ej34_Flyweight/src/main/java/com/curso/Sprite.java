package com.curso;

import java.awt.Image;

public class Sprite {

	private int x = 40;
	private int y = 60;
	private SpriteIntrinseco spriteIntrinseco = SpriteIntrinseco.getInstancia();

	public Sprite() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return spriteIntrinseco.getImage();
	}

}