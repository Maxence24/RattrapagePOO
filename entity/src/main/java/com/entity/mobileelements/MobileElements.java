package com.entity.mobileelements;

import java.io.IOException;

import com.collisionhandler.CollisionsHandler;
import com.entity.motionlesselements.Blueline;
import com.entity.motionlesselements.Redline;

import entity.Entity;
import entity.Sprite;

public class MobileElements extends Entity {

	protected boolean isAlive;
	private final int speed;

	public MobileElements(Sprite sprite, int x, int y, final int speed) {
		super(sprite, x, y);
		this.speed = speed;
	}

	public void enitymove(int x, int y, char direction) {
		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final Player1 player1 = this.getMap().getPlayer1();
		final Player2 player2 = this.getMap().getPlayer2();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision1 = false;
		boolean collision2 = false;
		boolean isPlayer = false;

		if (this instanceof Player1) {
			collision1 = getCollisionHandler.checkForCollisions(loadArrayMap, xpos + x, ypos + y);
		} else {
			collision1 = getCollisionHandler.checkForBackground(loadArrayMap, xpos + x, ypos + y);
		}
		// this.loadImage1(direction, this);
		if (!collision1) {

			loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
			loadArrayMap[xpos][ypos] = new Redline(xpos, ypos);
			this.setPositionY(ypos + y);
			this.setPositionX(xpos + x);

		}
		if (this instanceof Player2) {
			collision2 = getCollisionHandler.checkForCollisions(loadArrayMap, xpos + x, ypos + y);
		} else {
			collision2 = getCollisionHandler.checkForBackground(loadArrayMap, xpos + x, ypos + y);
		}
		// this.loadImage1(direction, this);
		if (!collision2) {

			loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
			loadArrayMap[xpos][ypos] = new Blueline(xpos, ypos);
			this.setPositionY(ypos + y);
			this.setPositionX(xpos + x);
		}
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
		case 'S':
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

		case 'M':
			entity.setSprite(entity.getSpritePlayer2());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'L':
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
