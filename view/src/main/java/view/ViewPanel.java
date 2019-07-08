package view;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.entity.mobileelements.Player1;
import com.entity.mobileelements.Player2;
import com.entity.motionlesselements.Background;
import com.entity.motionlesselements.Blueline;
import com.entity.motionlesselements.Redline;
import com.entity.motionlesselements.Wall;

import contract.IModel;
import entity.Entity;
import entity.Map;

class ViewPanel extends JPanel implements Observer {

	private ViewFrame viewFrame;
	private static final long serialVersionUID = -998294702363713521L;
	private boolean toStop = false;
	boolean Winner1;
	boolean Winner2;
	

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
		Map map = this.viewFrame.getModel().getMap();
		Entity[][] loadMap = map.getArrayMap();
		Player1 player1 = null;
		Player2 player2 = null;
		final int width = 23;
		final int height = 25;

		player1 = this.viewFrame.getModel().getMap().getPlayer1();
		Font font1 = new Font("Arial", Font.BOLD, 20);
		graphics.setFont(font1);

		player2 = this.viewFrame.getModel().getMap().getPlayer2();
		Font font2 = new Font("Arial", Font.BOLD, 20);
		graphics.setFont(font2);

		this.displayMap(graphics, width, height);
	}

	public void displayMap(Graphics graphics, int width, int height) {
		final int imageSize = 16;
		Map map = this.viewFrame.getModel().getMap();
		Entity[][] loadMap = map.getArrayMap();
		Player1 player1 = this.viewFrame.getModel().getMap().getPlayer1();
		Player2 player2 = this.viewFrame.getModel().getMap().getPlayer2();
		for (int x = 0; x < 23; x++) {
			for (int y = 0; y < 25; y++) {
				if (loadMap[x][y] instanceof Wall) {
					graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
				} else if (loadMap[x][y] instanceof Background) {
					graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
				} else if (loadMap[x][y] instanceof Player1) {
					graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
				} else if (loadMap[x][y] instanceof Player2) {
					graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
				} else if (loadMap[x][y] instanceof Redline) {
					graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
				} else if (loadMap[x][y] instanceof Blueline) {
					graphics.drawImage(loadMap[x][y].getSprite().getImage(), x * imageSize, y * imageSize, this);
				}
			}
		}
		if (!player1.getIsAlive1() && toStop == false) {
			int number = 1;
			toStop = true;
			graphics.clearRect(0, 0, 600, 400);
			this.viewFrame.printMessage("Congratulations Player 2, you won !");
			this.viewFrame.getModel().isWinner(number);
			System.exit(0);
		}
		if (!player2.getIsAlive2() && toStop == false) {
			int number = 2;
			toStop = true;
			graphics.clearRect(0, 0, 600, 400);
			this.viewFrame.printMessage("Congratulations Player 1, you won !");
			this.viewFrame.getModel().isWinner(number);
			System.exit(0);
		}
	}
}
