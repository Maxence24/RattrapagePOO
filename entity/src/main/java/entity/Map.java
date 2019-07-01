package entity;

import com.collisionhandler.CollisionsHandler;
import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;
import com.entity.motionlesselements.Background;
import com.entity.motionlesselements.Blueline;
import com.entity.motionlesselements.Redline;
import com.entity.motionlesselements.Wall;

public class Map extends Entity {

	private String contentOfMap;
	private Entity[][] mapToChars;
	public Map map;
	private CollisionsHandler collisionsHandler;

	public Map(final String content) {
		map = new Map("wwwwwwwwwwwwwwww\r\n" + "wfddddddddddddddw\r\n" + "wdddddddddddddddw\r\n"
				+ "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n"
				+ "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n"
				+ "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n" + "wdddddddddddddddw\r\n" + "wddddddddddddddsw\r\n"
				+ "wwwwwwwwwwwwwwww\r\n");
		this.createMapToChars();
	}

	private void createMapToChars() {
		String map = this.getContentOfMap();
		if (getHeightMap() >= 1 && getWidthMap() >= 1) {
			this.mapToChars = new Entity[this.getWidthMap()][this.getHeightMap()];
			for (int y = 0; y < getHeightMap(); y++) {
				String[] finalMap = map.split("\n");
				for (int x = 0; x < getWidthMap(); x++) {
					switch (finalMap[y].toCharArray()[x]) {
					case 'w':
						mapToChars[x][y] = new Wall(x, y);
						break;
					case 'd':
						mapToChars[x][y] = new Background(x, y);
						break;
					case 'f':
						mapToChars[x][y] = new Player1(x, y);
						break;
					case 's':
						mapToChars[x][y] = new Player2(x, y);
						break;
					case 'r':
						mapToChars[x][y] = new Redline(x, y);
						break;
					case 'b':
						mapToChars[x][y] = new Blueline(x, y);
						break;
					default:
						break;
					}
					mapToChars[x][y].setMap(this);
				}
			}
		}
	}

	public Player1 getPlayer1() {
		Entity[][] entity = this.getArrayMap();
		for (int y = 0; y < getHeightMap(); y++) {
			for (int x = 0; x < getWidthMap(); x++) {
				if (entity[x][y] instanceof Player1) {
					return (Player1) entity[x][y];
				}
			}
		}
		return null;
	}

	public Player2 getPlayer2() {
		Entity[][] entity = this.getArrayMap();
		for (int y = 0; y < getHeightMap(); y++) {
			for (int x = 0; x < getWidthMap(); x++) {
				if (entity[x][y] instanceof Player2) {
					return (Player2) entity[x][y];
				}
			}
		}
		return null;
	}

	public void loop1() {
		Player1 p = this.getPlayer1();
		if (p != null) {
			p.player1DeathLinkToplayer2();
		}
	}

	public void loop2() {
		Player2 p = this.getPlayer2();
		if (p != null) {
			p.player2DeathLinkToplayer1();
		}
	}

	public Entity[][] getArrayMap() {

		return this.mapToChars;
	}

	public int getHeightMap() {
		String[] mapFirstLength = getContentOfMap().split("\n");
		return mapFirstLength.length;
	}

	public int getWidthMap() {
		String[] mapFirstLength = getContentOfMap().split("\n");
		return mapFirstLength[0].length() - 1;
	}

	public String getContentOfMap() {
		return contentOfMap;
	}

	public void setContentOfMap(String contentOfMap) {
		this.contentOfMap = contentOfMap;
	}

	public void setCollisionsHandler(CollisionsHandler collisionsHandler) {
		this.collisionsHandler = collisionsHandler;
	}

	public CollisionsHandler getCollisionsHandler() {
		return collisionsHandler;
	}

}
