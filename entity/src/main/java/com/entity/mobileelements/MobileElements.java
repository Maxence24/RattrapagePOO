package com.entity.mobileelements;

import java.io.IOException;

import com.collisionhandler.CollisionsHandler;
import com.entity.motionlesselements.Redline;

import entity.Entity;
import entity.Sprite;

public class MobileElements extends Entity {

	protected boolean isAlive;

	public MobileElements(Sprite sprite, int x, int y, final int speed) {
		super(sprite, x, y);
	}

	

	public void loadImage1(char direction, Entity entity) {

		switch (direction) {

		case 'Q':
			entity.setSprite(entity.getSpritePlayer1());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'D':
			entity.setSprite(entity.getSpritePlayer1());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	public void loadImage2(char direction, Entity entity) {

		switch (direction) {

		case '1':
			entity.setSprite(entity.getSpritePlayer2());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case '2':
			entity.setSprite(entity.getSpritePlayer2());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	public boolean getIsAlive() {
		return this.isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
