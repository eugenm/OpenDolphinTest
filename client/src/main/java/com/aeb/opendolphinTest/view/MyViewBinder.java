package com.aeb.opendolphinTest.view;

import com.aeb.opendolphinTest.Constants;
import com.aeb.opendolphinTest.model.MyModel;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * This class binds a view isnatnce that is created based on the view.fxml (see ClientApplication class).
 * The class extends the {@link AbstractViewBinder} class that is part of the basic DOlphin Platform JavaFX client API and
 * already defines the lifecycle of the view and offers several properties and features. When extending this class normally
 * only the init() method need to be defined. Here all the UI components should be bound to the model taht is synchronized
 * between client and server.
 */
public class MyViewBinder extends AbstractViewBinder<MyModel> {

    /**
     * This UI control is automatically injected by FXML
     */
    @FXML
    private TextField valueField;

    /**
     * This UI control is automatically injected by FXML
     */
    @FXML
    private Button resetButton;

    /**
     * The constructor calls the super constructor taht initializes the view lifecycle that is defined by Dolphin Platform.
     * This will automatically create a controller instance on the server. In addition the model of this MVC group will
     * be created and synchronized between client and server.
     * @param clientContext the global client context
     */
    public MyViewBinder(ClientContext clientContext) {
        super(clientContext, Constants.CONTROLLER_NAME);
    }

    /**
     * This method is called when the Dolphin Platform bootstrap for the view is finished. This means that a controller
     * isntance has been created on the server and the model for the MVC group was instantiated on the client and the server.
     * In this client the model is bound to the UI. In addition user interaction that will trigger controller actions is
     * defined.
     */
    @Override
    protected void init() {
        // The FXBinder class is part of the Dolphin Platform JavaFX client API and offers a fluent API to create
        // (bidirectional) bindings between JavaFX properties and Dolphin Platform properties
        FXBinder.bind(valueField.textProperty()).bidirectionalTo(getModel().valueProperty());

        // pressing the button will invoke the reset action on the controller instance on the server
        resetButton.setOnAction(e -> invoke("reset"));
    }
}
