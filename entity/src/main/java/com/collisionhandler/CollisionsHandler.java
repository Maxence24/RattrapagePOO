package com.collisionhandler;

import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;
import com.entity.motionlesselements.Background;
import com.entity.motionlesselements.Blueline;
import com.entity.motionlesselements.Redline;
import com.entity.motionlesselements.Wall;

import entity.Entity;

public class CollisionsHandler {

	public CollisionsHandler() {

	}

	public boolean checkForCollisions1(Entity[][] entity, int x, int y) {
		if (entity[x][y] instanceof Player2) {
			return true;
		} else if (entity[x][y] instanceof Wall) {
			return true;
		} else if (entity[x][y] instanceof Blueline) {
			return true;
		} else if (entity[x][y] instanceof Redline) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForPlayer1(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Player1) {
			return true;
		}
		return false;
	}

	public boolean checkForCollisions2(Entity[][] entity, int x, int y) {
		if (entity[x][y] instanceof Player1) {
			return true;
		} else if (entity[x][y] instanceof Wall) {
			return true;
		} else if (entity[x][y] instanceof Blueline) {
			return true;
		} else if (entity[x][y] instanceof Redline) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForPlayer2(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Player2) {
			return true;
		}
		return false;
	}

	public boolean checkForBackground(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Background) {
			return false;
		}
		return true;
	}
}
