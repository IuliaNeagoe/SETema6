package tema6.mvc.views;

import tema6.mvc.interfaces.IController;
import tema6.mvc.interfaces.IModelListener;
import tema6.mvc.interfaces.IView;
import tema6.mvc.model.MyModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IuliS on 23.11.2014.
 */
public class MyView extends JFrame implements IModelListener,IView{
    private static final long serialVersionUID = -5758555454500685115L;
    //the view components
    private JTextField txtTemperature = new JTextField(10);
    private JTextField txtWindSpeed = new JTextField(10);
    private JButton btnRandomUpdate = new JButton("Update");

    private IController mController;

    private MyModel mModel;

    public MyView() {
        // Initialize components
        txtTemperature.setEditable(false);
        txtWindSpeed.setEditable(false);

        // Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Temperature"));
        content.add(txtTemperature);
        content.add(new JLabel("ºC"));
        content.add(new JLabel("    Wind Speed"));
        content.add(txtWindSpeed);
        content.add(new JLabel("m/s"));
        content.add(btnRandomUpdate);

        // finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("Weather Monitor for Bucharest");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * * Sets the reference of the view to the model
     *
     * * @param model
     */
    public void addModel(MyModel model) {
        mModel = model;
        txtTemperature.setText(model.getTemperature());
        txtWindSpeed.setText(model.getWindSpeed());
    }

    /**
     *Sets the event listener of the view
     * @param controller
     */
    public void addController(IController controller) {
        btnRandomUpdate.setActionCommand(IController.ACTION_UPDATE);
        btnRandomUpdate.addActionListener(controller);
    }
    @Override
    public void onUpdate() {
        txtTemperature.setText(mModel.getTemperature());
        txtWindSpeed.setText(mModel.getWindSpeed());

    }

    @Override
    public void onMessage(boolean isError, String message) {
        if (isError) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Weather Monitor MVC", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
