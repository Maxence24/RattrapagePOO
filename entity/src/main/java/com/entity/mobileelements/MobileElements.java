package com.entity.mobileelements;

import java.io.IOException;

import com.collisionhandler.CollisionsHandler;
import com.entity.motionlesselements.Redline;

import entity.Entity;
import entity.Sprite;

public class MobileElements extends Entity {

	protected boolean isAlive;

	public MobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	public void entityMove1(int x, int y, int sideX, char direction) {

		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final Player1 player1 = this.getMap().getPlayer1();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision = false;
		boolean isPlayer = false;

		if (this instanceof Player1) {
			collision = getCollisionHandler.checkForCollisions1(loadArrayMap, xpos + x, ypos + y);
		} else {
			collision = getCollisionHandler.checkForBackground(loadArrayMap, xpos + x, ypos + y);
			isPlayer = getCollisionHandler.checkForPlayer1(loadArrayMap, xpos + x, ypos + y);
		}

		this.loadImage1(direction, this);

		if (!collision) {

			if (isPlayer == true) {
				player1.setIsAlive(false);
			} else {
				loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
				loadArrayMap[xpos][ypos] = new Redline(xpos, ypos);
				this.setPositionY(ypos + y);
				this.setPositionX(xpos + x);
			}

		}

	}

	public void entityMove2(int x, int y, int sideX, char direction) {

		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final Player2 player2 = this.getMap().getPlayer2();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision = false;
		boolean isPlayer = false;

		if (this instanceof Player1) {
			collision = getCollisionHandler.checkForCollisions1(loadArrayMap, xpos + x, ypos + y);
		} else {
			collision = getCollisionHandler.checkForBackground(loadArrayMap, xpos + x, ypos + y);
			isPlayer = getCollisionHandler.checkForPlayer1(loadArrayMap, xpos + x, ypos + y);
		}

		this.loadImage1(direction, this);

		if (!collision) {

			if (isPlayer == true) {
				player2.setIsAlive(false);
			} else {
				loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
				loadArrayMap[xpos][ypos] = new Redline(xpos, ypos);
				this.setPositionY(ypos + y);
				this.setPositionX(xpos + x);
			}

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
