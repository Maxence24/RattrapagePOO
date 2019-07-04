package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Redline;

import entity.Sprite;

public class Player2 extends MobileElements {

	private static final Sprite spritePlayer2 = new Sprite('y', "Plan_de_travail_1-100.jpg");
	private boolean isWin;
	private static int	SPEED		= 2;

	static {
		try {
			spritePlayer2.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player2(int x, int y) {
		super(spritePlayer2, x, y, SPEED);
		this.isAlive = true;
		this.isWin = false;

	}

	public Sprite getSpritePlayer2() {
		return spritePlayer2;
	}

	public void movePlayer(char direction) {

		if (this.getIsAlive()) {
			switch (direction) {

			case '1':
				this.entityMove2(0, -1, 0, direction);
				break;
			case '2':
				this.entityMove2(-1, 0, -1, direction);
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

	public void player2DeathLinkToplayer1() {

		int x = this.getPositionX();
		int y = this.getPositionY();

		if (this.getMap().getArrayMap()[x + 1][y] instanceof Redline
				|| this.getMap().getArrayMap()[x - 1][y] instanceof Redline
				|| this.getMap().getArrayMap()[x][y + 1] instanceof Redline
				|| this.getMap().getArrayMap()[x][y - 1] instanceof Redline) {
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
