package tema6.mvc.controllers;

import tema6.mvc.interfaces.IController;
import tema6.mvc.interfaces.IView;
import tema6.mvc.model.MyModel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IuliS on 23.11.2014.
 */
public class MyController implements IController{

    private MyModel mModel;

    // The list of views that listen for updates
    private List<IView> mViews;

    //implicit constructor
    public MyController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_UPDATE)) {
            makeOperation();
        }
    }


    /**
     * Adds a view reference
     *
     * @param view
     */
    public void addView(IView view) {
        if (mViews == null) {
            mViews = new ArrayList<IView>();
        }

        mViews.add(view);
    }

    /**
     * Adds a reference to the model, so it can update it
     *
     * @param model The data model reference
     */
    public void addModel(MyModel model) {
        mModel = model;
    }

    /**
     * Notifies the views when an message must be displayed
     *
     * @param isError {@code true} if the message is an error, {@code false} otherwise
     * @param message The string to be displayed
     */
    private void notifyViews(boolean isError, String message) {
        if (mViews != null && !mViews.isEmpty()) {
            for (IView view : mViews) {
                view.onMessage(isError, message);
            }
        }
    }


    //action on click on the Update button
    private void makeOperation()
    {
        Random generatorOfRandomValues = new Random();
        String temp= String.valueOf(generatorOfRandomValues.nextDouble() + generatorOfRandomValues.nextInt(40)).substring(0,5);
        String wind= String.valueOf(generatorOfRandomValues.nextDouble() + generatorOfRandomValues.nextInt(50)).substring(0,5);
        //System.out.println(temp + " " + wind);
        mModel.setTemperature(temp);
        mModel.setWindSpeed(wind);
    }
}
