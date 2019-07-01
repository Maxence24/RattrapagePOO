package com.entity.motionlesselements;

import java.io.IOException;

import entity.Sprite;

public class Wall extends MotionlessElements{

	private static final Sprite sprite = new Sprite('w', "Wall.png");

	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Wall(int x, int y) {
		super(sprite, x, y);
	}
}
