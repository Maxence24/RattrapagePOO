package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Redline;

import entity.Sprite;

public class Player2 extends MobileElements {

	private static final Sprite spritePlayer2 = new Sprite('y', "bleu_gauche.jpg");
	private int lastDirectionX;
	private int lastDirectionY;

	static {
		try {
			spritePlayer2.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player2(int x, int y) {
		super(spritePlayer2, x, y);
		this.isAlive2 = true;

	}

	public Sprite getSpritePlayer2() {
		return spritePlayer2;
	}

	public void movePlayer2(char direction) {
		if (this.getIsAlive2()) {
			switch (direction) {

			case 'L':
				if (lastDirectionX == 0 && lastDirectionY == -1) {
					this.enitymove2(-1, 0);
					this.setLastDirection2(-1, 0);
				} else if (lastDirectionX == -1 && lastDirectionY == 0) {
					this.enitymove2(0, +1);
					this.setLastDirection2(0, +1);
				} else if (lastDirectionX == 0 && lastDirectionY == +1) {
					this.enitymove2(+1, 0);
					this.setLastDirection2(+1, 0);
				} else if (lastDirectionX == +1 && lastDirectionY == 0) {
					this.enitymove2(0, -1);
					this.setLastDirection2(0, -1);
				} else {
					this.enitymove2(-1, 0);
					this.setLastDirection2(-1, 0);
				}
				break;
			case 'M':
				if (lastDirectionX == +1 && lastDirectionY == 0) {
					this.enitymove2(0, +1);
					this.setLastDirection2(0, +1);
				} else if (lastDirectionX == -1 && lastDirectionY == 0) {
					this.enitymove2(0, -1);
					this.setLastDirection2(0, -1);
				} else if (lastDirectionX == 0 && lastDirectionY == +1) {
					this.enitymove2(-1, 0);
					this.setLastDirection2(-1, 0);
				} else if (lastDirectionX == 0 && lastDirectionY == -1) {
					this.enitymove2(+1, 0);
					this.setLastDirection2(+1, 0);
				} else {
					this.enitymove2(+1, 0);
					this.setLastDirection2(+1, 0);
				}
				break;
			}
		}
	}


	public void player2DeathLinkToplayer1() {

		int x = this.getPositionX();
		int y = this.getPositionY();

		if (this.getMap().getArrayMap()[x + 1][y] instanceof Redline
				|| this.getMap().getArrayMap()[x - 1][y] instanceof Redline
				|| this.getMap().getArrayMap()[x][y + 1] instanceof Redline
				|| this.getMap().getArrayMap()[x][y - 1] instanceof Redline) {
			this.setIsAlive2(false);
			//this.loadImage1(this);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setLastDirection2(int x, int y) {
		this.lastDirectionX = x;
		this.lastDirectionY = y;
	}

	public int getLastDirectionXPlayer2() {
		return lastDirectionX;
	}

	public int getLastDirectionYPlayer2() {
		return lastDirectionY;
	}

	public void defaultDirection2() {
		this.enitymove2(this.getLastDirectionXPlayer2(), this.getLastDirectionYPlayer2());
	}

}
