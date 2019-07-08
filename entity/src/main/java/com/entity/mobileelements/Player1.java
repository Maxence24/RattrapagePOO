package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Blueline;

import entity.Sprite;

public class Player1 extends MobileElements {

	private static final Sprite spritePlayer1 = new Sprite('y', "Plan_de_travail_1-100.jpg");
	private boolean isWin;
	private int lastDirectionX;
	private int lastDirectionY;

	static {
		try {
			spritePlayer1.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player1(int x, int y) {
		super(spritePlayer1, x, y);
		this.isAlive1 = true;
		this.isWin = false;

	}

	public Sprite getSpritePlayer1() {
		return spritePlayer1;
	}

	public void movePlayer1(char direction) {
		if (this.getIsAlive1()) {
			switch (direction) {

			case 'Q':
				if (lastDirectionX == 0 && lastDirectionY == -1) {
					this.enitymove1(-1, 0);
					this.setLastDirection1(-1, 0);
				} else if (lastDirectionX == -1 && lastDirectionY == 0) {
					this.enitymove1(0, +1);
					this.setLastDirection1(0, +1);
				} else if (lastDirectionX == 0 && lastDirectionY == +1) {
					this.enitymove1(+1, 0);
					this.setLastDirection1(+1, 0);
				} else if (lastDirectionX == +1 && lastDirectionY == 0) {
					this.enitymove1(0, -1);
					this.setLastDirection1(0, -1);
				} else {
					this.enitymove1(-1, 0);
					this.setLastDirection1(-1, 0);
				}
				break;
			case 'S':
				if (lastDirectionX == +1 && lastDirectionY == 0) {
					this.enitymove1(0, +1);
					this.setLastDirection1(0, +1);
				} else if (lastDirectionX == -1 && lastDirectionY == 0) {
					this.enitymove1(0, -1);
					this.setLastDirection1(0, -1);
				} else if (lastDirectionX == 0 && lastDirectionY == +1) {
					this.enitymove1(-1, 0);
					this.setLastDirection1(-1, 0);
				} else if (lastDirectionX == 0 && lastDirectionY == -1) {
					this.enitymove1(+1, 0);
					this.setLastDirection1(+1, 0);
				} else {
					this.enitymove1(+1, 0);
					this.setLastDirection1(+1, 0);
				}
				break;
			}
		}
	}

	public void setLastDirection1(int x, int y) {
		this.lastDirectionX = x;
		this.lastDirectionY = y;
	}

	public int getLastDirectionXPlayer1() {
		return lastDirectionX;
	}

	public int getLastDirectionYPlayer1() {
		return lastDirectionY;
	}

	public void defaultDirection1() {
		this.enitymove1(this.getLastDirectionXPlayer1(), this.getLastDirectionYPlayer1());
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
			this.setIsAlive1(false);
			//this.loadImage1( this);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
