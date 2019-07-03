package model;

import java.util.Observable;

import contract.IModel;
import entity.Map;

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
		this.getMap();
		this.modelNotify();
	}

}