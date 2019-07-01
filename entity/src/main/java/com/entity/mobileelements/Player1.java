package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Blueline;

import entity.Sprite;

public class Player1 extends MobileElements {

	private static final Sprite spritePlayer1 = new Sprite('y', "Rockford.png");
	private boolean isWin;

	static {
		try {
			spritePlayer1.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player1(int x, int y) {
		super(spritePlayer1, x, y);
		this.isAlive = true;
		this.isWin = false;

	}

	public Sprite getSpritePlayer1() {
		return spritePlayer1;
	}

	public void movePlayer(char direction) {

		if (this.getIsAlive()) {
			switch (direction) {

			case 'Q':
				this.entityMove1(0, -1, 0, direction);
				break;
			case 'D':
				this.entityMove1(-1, 0, -1, direction);
				break;
			}
		}
	}

	public boolean getIsWin() {
		return isWin;
	}

	public void setIsWin(boolean isWin) {
		this.isWin = isWin;
	}

	public void player1DeathLinkToplayer2() {

		int x = this.getPositionX();
		int y = this.getPositionY();

		if (this.getMap().getArrayMap()[x + 1][y] instanceof Blueline
				|| this.getMap().getArrayMap()[x - 1][y] instanceof Blueline
				|| this.getMap().getArrayMap()[x][y + 1] instanceof Blueline
				|| this.getMap().getArrayMap()[x][y - 1] instanceof Blueline) {
			this.setIsAlive(false);
			this.loadImage1('X', this);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
