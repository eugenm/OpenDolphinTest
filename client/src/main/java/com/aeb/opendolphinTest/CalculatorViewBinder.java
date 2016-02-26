package com.aeb.opendolphinTest;

import com.aeb.opendolphinTest.model.CalculatorModel;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorViewBinder extends AbstractViewBinder<CalculatorModel> {

	@FXML
	private TextField valueAField;

	@FXML
	private TextField valueBField;

	@FXML
	private TextField resultField;

	@FXML
	private Button resetButton;

	public CalculatorViewBinder(ClientContext clientContext) {
		super(clientContext, Constants.CalcController_NAME);
	}

	@Override
	protected void init() {
		FXBinder.bind(getModel().firstValueProperty()).bidirectionalTo(valueAField.textProperty());
		FXBinder.bind(getModel().secondValueProperty()).bidirectionalTo(valueBField.textProperty());
		FXBinder.bind(getModel().resultProperty()).bidirectionalTo(resultField.textProperty());
		resetButton.setOnAction(e -> invoke("reset"));
	}
}