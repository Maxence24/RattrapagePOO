
package main;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {

	public static void main(final String[] args) {
		final Model model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		final  int SPEED = 200;
		view.setController(controller);

		controller.control();
		controller.orderPerform(ControllerOrder.S);
        controller.orderPerform(ControllerOrder.L);
		controller.start(SPEED);
	}
}
