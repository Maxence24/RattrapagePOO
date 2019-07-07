package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {
	private IView view;
	private IModel model;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	public void control() {
		this.view.printMessage("TRON is start ");
	}

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case Q:
			this.model.getMap().getPlayer1().movePlayer1('Q');
			break;
		case S:
			this.model.getMap().getPlayer1().movePlayer1('S');
			break;
		case L:
			this.model.getMap().getPlayer2().movePlayer2('L');
			break;
		case M:
			this.model.getMap().getPlayer2().movePlayer2('M');
			break;
		default:
			break;
		}
	}

	public void start() {

		while (true) {
			this.model.loop();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
