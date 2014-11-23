package tema6.mvc.interfaces;

import java.awt.event.ActionListener;

/**
 * Created by IuliS on 23.11.2014.
 * * The interface implemented by controller and made public so that all views can use it
 */
public interface IController extends ActionListener {
    public static final String ACTION_UPDATE = "UPDATE";
}
