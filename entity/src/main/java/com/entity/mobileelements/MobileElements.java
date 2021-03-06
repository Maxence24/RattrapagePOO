package com.entity.mobileelements;

import java.io.IOException;

import com.collisionhandler.CollisionsHandler;
import com.entity.motionlesselements.Blueline;
import com.entity.motionlesselements.Redline;

import entity.Entity;
import entity.Sprite;

public class MobileElements extends Entity {

	protected boolean isAlive1;
	protected boolean isAlive2;
	private boolean Winner1;
	private boolean Winner2;

	public MobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);

	}

	public void enitymove1(int x, int y) {
		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision1 = false;

		if (this instanceof Player1) {
			collision1 = getCollisionHandler.checkForCollisions(loadArrayMap, xpos + x, ypos + y);
		} else {
			collision1 = getCollisionHandler.checkForBackground(loadArrayMap, xpos + x, ypos + y);
		}
		if (!collision1) {

			loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
			loadArrayMap[xpos][ypos] = new Redline(xpos, ypos);
			this.setPositionY(ypos + y);
			this.setPositionX(xpos + x);
		} else if (collision1) {
			this.setIsAlive1(false);
			this.Winner1 = false;
			this.Winner2 = true;
		}
	}

	public void enitymove2(int x, int y) {
		final int xpos = this.getPositionX();
		final int ypos = this.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision2 = false;

		if (this instanceof Player1) {
			collision2 = getCollisionHandler.checkForCollisions(loadArrayMap, xpos + x, ypos + y);
		} else {
			collision2 = getCollisionHandler.checkForBackground(loadArrayMap, xpos + x, ypos + y);
		}
		if (!collision2) {

			loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
			loadArrayMap[xpos][ypos] = new Blueline(xpos, ypos);
			this.setPositionY(ypos + y);
			this.setPositionX(xpos + x);
		} else if (collision2) {
			this.setIsAlive2(false);
			this.Winner1 = true;
			this.Winner2 = false;
		}

	}

	public boolean getIsAlive1() {
		return this.isAlive1;
	}

	public void setIsAlive1(boolean isAlive1) {
		this.isAlive1 = isAlive1;
	}

	public boolean getIsAlive2() {
		return this.isAlive2;
	}

	public void setIsAlive2(boolean isAlive2) {
		this.isAlive2 = isAlive2;
	}

	public boolean getWinner1() {
		return Winner1 = false;
	}

	public boolean setWinner1(boolean Winner1) {
		return this.Winner1 = Winner1;
	}

	public boolean getWinner2() {
		return Winner2 = false;
	}

	public boolean setWinner2(boolean Winner2) {
		return this.Winner2 = Winner2;
	}
}
