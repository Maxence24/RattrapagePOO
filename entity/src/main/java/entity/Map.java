package entity;

import com.collisionhandler.CollisionsHandler;
import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;
import com.entity.motionlesselements.Background;
import com.entity.motionlesselements.Blueline;
import com.entity.motionlesselements.Redline;
import com.entity.motionlesselements.Wall;

public class Map extends Entity {

	private Entity[][] mapToChars;
	public Map map;
	private int id;
	private CollisionsHandler collisionsHandler;
	private static String MapForme = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnonnnnnnnnnnnnnnnnnnnnnnnnntnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnw\r\n"
			+ "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";

	public Map(final int id, final String content) {
		this.setId(id);
		this.setMapForme(content);
		this.setcreateMapToChars();

	}

	public Map() {
		this(1, MapForme);
	}

	public String getMapForme() {
		return this.MapForme;
	}

	public void setMapForme(final String content) {
		this.MapForme = content;
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	private void setcreateMapToChars() {
		String map = this.getMapForme();
		int HeightMap = 49;
		int WidthMap = 74;
		this.mapToChars = new Entity[WidthMap][HeightMap];

		for (int y = 0; y < HeightMap; y++) {
			String[] finalMap = map.split("\n");
			for (int x = 0; x < WidthMap; x++) {
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

	public Player1 getPlayer1() {
		Entity[][] entity = this.getArrayMap();
		for (int y = 0; y < 49; y++) {
			for (int x = 0; x < 74; x++) {
				if (entity[x][y] instanceof Player1) {
					return (Player1) entity[x][y];
				}
			}
		}
		return null;
	}

	public Player2 getPlayer2() {
		Entity[][] entity = this.getArrayMap();
		for (int y = 0; y < 79; y++) {
			for (int x = 0; x < 74; x++) {
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
	/*
	 * public Entity[][] getArrayMap() {
	 * 
	 * return this.mapToChars; }
	 * 
	 * public String getContentOfMap() { return contentOfMap; }
	 */

	public void setCollisionsHandler(CollisionsHandler collisionsHandler) {
		this.collisionsHandler = collisionsHandler;
	}

	public CollisionsHandler getCollisionsHandler() {
		return collisionsHandler;
	}

}
