package com.aeb.opendolphinTest;

import com.aeb.opendolphinTest.view.FormViewBinder;
import com.aeb.opendolphinTest.view.MyViewBinder;
import com.canoo.dolphin.client.ClientConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.ClientContextFactory;
import com.canoo.dolphin.client.javafx.JavaFXConfiguration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormClientApplication extends Application {
	//MAIN
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	
	
	private ClientContext clientContext;

	@Override
	public void init() throws Exception {
		// Creates a configuration for the Dolphin Platform. Here the server
		// endpoint is configured
		ClientConfiguration config = new JavaFXConfiguration("http://localhost:8080/dolphin");

		// Creates the global client context based on the configuration
		clientContext = ClientContextFactory.connect(config).get();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Loads the view based on a FXML file
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("FormView.fxml"));

        //Defines the FXML controller for the view. In this case the controller defines all the bindings
        //between the view and the synchronized Dolphin Platform model.
        loader.setController(new FormViewBinder(clientContext, Constants.FORM_CONTROLLER_NAME));

        //Shows the JavaFX client on the screen
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
