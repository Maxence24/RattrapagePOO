package contract;

import java.util.Observable;

import entity.Map;

public interface IModel {

	Observable getObservable();

	Map getMap();

	void loadMap(int id);

	void modelNotify();
	
	void loop();
}
