package tema6.mvc.interfaces;

/**
 * Created by IuliS on 23.11.2014.
 */
public interface IView {
    /**
     * When is received a message from the controller
     * @param isError
     * @param message
     */
    public void onMessage(boolean isError, String message);
}
