package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class View implements IView, Runnable {

	private ViewFrame viewFrame = null;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	public View() {

	}

	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_Q:
			return ControllerOrder.Q;
		case KeyEvent.VK_S:
			return ControllerOrder.S;
		case KeyEvent.VK_L:
			return ControllerOrder.L;
		case KeyEvent.VK_M:
			return ControllerOrder.M;
		default:
			return ControllerOrder.nothing;
		}
	}

	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
