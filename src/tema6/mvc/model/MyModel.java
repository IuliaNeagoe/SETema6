package tema6.mvc.model;

import tema6.mvc.interfaces.IModelListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IuliS on 23.11.2014.
 */
public class MyModel {

    public static final double INITIAL_TEMPERATURE = 5;
    public static final double INITIAL_WSPEED = 20;
    private double temperature;
    private double windSpeed;

    private List<IModelListener> mListeners;

    /**
     * basic constructor
     */
    public MyModel() {
        this.temperature = INITIAL_TEMPERATURE;
        this.windSpeed = INITIAL_WSPEED;
    }

    public String getWindSpeed() {
        return String.valueOf(windSpeed);
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = Double.parseDouble(windSpeed);
        notifyListeners();
    }

    public String getTemperature() {

        return String.valueOf(temperature);
    }

    public void setTemperature(String temperature) {
        this.temperature = Double.parseDouble(temperature);
        notifyListeners();
    }

    //adds a new listener (view in our case)
    public void addModelListener(IModelListener listener) {
        if (mListeners == null) {
            mListeners = new ArrayList<IModelListener>();
        }

        mListeners.add(listener);
    }

    /**
     * Notifies the views listeners of the changed state (value)
     */
    private void notifyListeners() {
        if (mListeners != null && !mListeners.isEmpty()) {
            for (IModelListener listener : mListeners)
                listener.onUpdate();
        }
    }
}
