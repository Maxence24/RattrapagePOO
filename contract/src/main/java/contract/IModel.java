package contract;

import java.util.Observable;

import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;

import entity.Map;

public interface IModel {

	Observable getObservable();

	Map getMap();
	
	Player1 getPlayer1();
	
	Player2 getPlayer2();

	void loadMap();

	void modelNotify();
	
	void loop();
}
