package com.entity.motionlesselements;

import java.io.IOException;

import entity.Sprite;

public class Background extends MotionlessElements {

	private static final Sprite sprite = new Sprite('d', "Background.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Background(int x, int y) {
		super(sprite, x, y);
	}
}
