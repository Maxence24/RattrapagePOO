package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Blueline;

import entity.Sprite;

public class Player1 extends MobileElements {

	private static final Sprite spritePlayer1 = new Sprite('y', "Plan_de_travail_1-100.jpg");
	private boolean isWin;
	private static int SPEED = 2;
	int s = 0;

	static {
		try {
			spritePlayer1.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player1(int x, int y) {
		super(spritePlayer1, x, y, SPEED);
		this.isAlive = true;
		this.isWin = false;

	}

	public Sprite getSpritePlayer1() {
		return spritePlayer1;
	}

	public void movePlayer1(char direction) {
		if (this.getIsAlive()) {
			switch (direction) {

			case 'Q':
				if (s == 0) {
					this.enitymove(0, -1, direction);
					s = 1;
				} else if (s == 1) {
					this.enitymove(-1, 0, direction);
					s = 2;
				} else if (s == 2) {
					this.enitymove(0, +1, direction);
					s = 3;
				} else if (s == 3) {
					this.enitymove(+1, 0, direction);
					s = 0;
				}
				break;
			case 'S':
				if (s == 0) {
					this.enitymove(0, +1, direction);
					s = 3;
				} else if (s == 1) {
					this.enitymove(+1, 0, direction);
					s = 0;
				} else if (s == 2) {
					this.enitymove(0, -1, direction);
					s = 1;
				} else if (s == 3) {
					this.enitymove(-1, 0, direction);
					s = 2;
				}
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
