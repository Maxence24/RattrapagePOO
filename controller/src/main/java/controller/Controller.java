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
		this.view.printMessage(
				"TRON is start ");
	}

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case FirstLeft:
			this.model.getMap();
			break;
		case FirstRight:
			this.model.getMap();
			break;
		case SecondLeft:
			this.model.getMap();
			break;
		case SecondRight:
			this.model.getMap();
			break;
		default:
			break;
		}
	}

}
