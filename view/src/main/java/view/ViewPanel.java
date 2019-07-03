package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;
import com.entity.motionlesselements.Background;
import com.entity.motionlesselements.Wall;

import contract.IModel;
import entity.Entity;
import entity.Map;

class ViewPanel extends JPanel implements Observer {

	private ViewFrame viewFrame;
	private static final long serialVersionUID = -998294702363713521L;
	private boolean isTimerStart = false;
	private boolean hasBeenNotifiedToStop = false;
	private static int counter = 200;

	public ViewPanel() {
	}

	public ViewPanel(ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		viewFrame.getModel().getMap();
	}

	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		final int imageSize = 8;
		Map map = this.viewFrame.getModel().getMap();
		Entity[][] loadMap = map.getArrayMap();
		Player1 player1 = null;
		final int width = 49;
		final int height = 74;

		if (map.getPlayer1() != null) {
			player1 = this.viewFrame.getModel().getMap().getPlayer1();
			int player1PosX = this.viewFrame.getModel().getMap().getPlayer1().getPositionX();
			int player1PosY = this.viewFrame.getModel().getMap().getPlayer1().getPositionY();
			Font font = new Font("Arial", Font.BOLD, 20);
			graphics.setFont(font);

		}

		this.displayMap(graphics, width, height);

	}

	public void displayMap(Graphics graphics, int width, int height) {
		final int imageSize = 8;
		Map map = this.viewFrame.getModel().getMap();
		IModel getModel = this.viewFrame.getModel();
		Entity[][] loadMap = map.getArrayMap();
		Player1 player1 = this.viewFrame.getModel().getMap().getPlayer1();
		for (int x = 0; x < 74; x++) {
			for (int y = 0; y < 49; y++) {
				if (loadMap[x][y] instanceof Wall) {
					graphics.setColor(Color.BLACK);
					graphics.fillRect(x * imageSize, y * imageSize, 8, 8);
				} else if (loadMap[x][y] instanceof Background) {
					graphics.setColor(Color.WHITE);
					graphics.fillRect(x * imageSize, y * imageSize, 8, 8);
				} else if (loadMap[x][y] instanceof Player1) {
					graphics.setColor(Color.BLUE);
					graphics.fillRect(x * imageSize, y * imageSize, 8, 8);
				} else if (loadMap[x][y] instanceof Player2) {
					graphics.setColor(Color.RED);
					graphics.fillRect(x * imageSize, y * imageSize, 8, 8);
				}

			}
		}
	}

	public void finalMap() {

	}

	/*
	 * public void displayMap(Graphics graphics, int width, int height) {
	 * 
	 * final int imageSize = 16; Map map = this.viewFrame.getModel().getMap();
	 * IModel getModel = this.viewFrame.getModel(); Entity[][] loadMap =
	 * map.getArrayMap(); Player1 player1 =
	 * this.viewFrame.getModel().getMap().getPlayer1(); Player2 player2 =
	 * this.viewFrame.getModel().getMap().getPlayer2(); final int timerResetValue =
	 * 200;
	 * 
	 * for (int x = 0; x < map.getWidthMap(); x++) { for (int y = 0; y <
	 * map.getHeightMap(); y++) {
	 * graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y *
	 * imageSize, this); } }
	 * 
	 * if (!player1.getIsAlive() && hasBeenNotifiedToStop == false &&
	 * !player2.getIsAlive() && hasBeenNotifiedToStop == false) {
	 * 
	 * hasBeenNotifiedToStop = true; graphics.clearRect(0, 0, width, height);
	 * this.viewFrame.printMessage("You died ! Try again..."); hasBeenNotifiedToStop
	 * = false;
	 * 
	 * } }
	 * 
	 * public void reverseFocusOnScreenAndStats(Graphics graphics, double scale, int
	 * width, int height, int playerPosX1, int playerPosY1, Player1 player1, int
	 * playerPosX2, int playerPosY2, Player2 player2, Map map, int imageSize) {
	 * 
	 * final int xStartStatsValues = width - 220; final int yStartStatsValues = 0;
	 * final int xEndStatsValues = 240; final int yEndStatsValues = 65; final int
	 * xStartStatsDisplay = width - 210;
	 * 
	 * ((Graphics2D) graphics).scale(1 / scale, 1 / scale);
	 * 
	 * graphics.translate((int) (+playerPosX1 * imageSize * scale - width / 2),
	 * (int) (+playerPosY1 * imageSize * scale - height / 2));
	 * graphics.setColor(Color.white); graphics.fillRect(xStartStatsValues,
	 * yStartStatsValues, xEndStatsValues, yEndStatsValues);
	 * graphics.setColor(Color.BLUE); graphics.drawString("Remaining time : " +
	 * counter, xStartStatsDisplay, 20); graphics.setColor(Color.RED);
	 * 
	 * graphics.translate((int) (+playerPosX2 * imageSize * scale - width / 2),
	 * (int) (+playerPosY1 * imageSize * scale - height / 2));
	 * graphics.setColor(Color.white); graphics.fillRect(xStartStatsValues,
	 * yStartStatsValues, xEndStatsValues, yEndStatsValues);
	 * graphics.setColor(Color.BLUE); graphics.drawString("Remaining time : " +
	 * counter, xStartStatsDisplay, 20); graphics.setColor(Color.RED);
	 * 
	 * }
	 * 
	 * public static void startTimer() { // This is a timer ViewPanel drawTimer =
	 * new ViewPanel(); TimerTask timerTask = new TimerTask() {
	 * 
	 * @Override public void run() { if (counter != -100 && counter > 0) {
	 * counter--;// increments the counter } } }; Timer timer = new
	 * Timer("MyTimer"); timer.scheduleAtFixedRate(timerTask, 1000, 1000); }
	 * 
	 * public int getCounter() { return counter; }
	 * 
	 * public void setCounter(int newCounter) throws IndexOutOfBoundsException { if
	 * (newCounter > 0 && newCounter < 10000) { ViewPanel.counter = newCounter; }
	 * else { throw new IndexOutOfBoundsException("Wrong parameters"); } }
	 */
}
