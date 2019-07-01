package com.entity.motionlesselements;

import java.io.IOException;

import entity.Sprite;

public class Redline extends MotionlessElements {

	private static final Sprite sprite = new Sprite('u', "Background.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Redline(int x, int y) {
		super(sprite, x, y);
	}
}
