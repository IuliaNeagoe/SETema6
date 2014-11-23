package tema6;

import tema6.mvc.controllers.MyController;
import tema6.mvc.model.MyModel;
import tema6.mvc.views.MyView;

/**
 * Created by IuliS on 23.11.2014.
 */
public class Main {

    public static void main(String[] args) {
        // Instantiate the MVC elements
        MyModel model = new MyModel();
        MyView view = new MyView();
        MyController controller = new MyController();

        // Attach the view to the model
        model.addModelListener(view);

        // Tell the view about the model and the controller
        view.addModel(model);
        view.addController(controller);

        // Tell the controller about the model and the view
        controller.addModel(model);
        controller.addView(view);

        // Display the view
        view.setVisible(true);

    }
}
