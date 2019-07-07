package model;

import java.util.Observable;

import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;

import contract.IModel;
import entity.Map;
import java.sql.CallableStatement;

public final class Model extends Observable implements IModel {

	private Map map;

	public Model() {
		this.map = new Map();
	}

	private void setMap(final Map map) {
		this.map = map;
		this.modelNotify();
	}

	public void loadMap(final int id) {
	}

	@Override
	public Map getMap() {
		return this.map;
	}

	public Observable getObservable() {
		return this;
	}

	@Override
	public void modelNotify() {
		setChanged();
		notifyObservers();
	}

	@Override
	public void loop() {
		if(this.getMap().getPlayer1() != null && this.getMap().getPlayer2() != null) {
		this.modelNotify();
		}
	}

	@Override
	public Player1 getPlayer1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player2 getPlayer2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadMap() {
		// TODO Auto-generated method stub
		
	}

}