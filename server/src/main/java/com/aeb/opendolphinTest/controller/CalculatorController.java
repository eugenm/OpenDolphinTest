package com.aeb.opendolphinTest.controller;

import javax.annotation.PostConstruct;

import com.aeb.opendolphinTest.Constants;
import com.aeb.opendolphinTest.model.CalculatorModel;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;

@DolphinController(Constants.CalcController_NAME)
public class CalculatorController {

    @DolphinModel
    private CalculatorModel model;

    @PostConstruct
    public void init() {
        model.firstValueProperty().onChanged(e -> calc());
        model.secondValueProperty().onChanged(e -> calc());
    }

    @DolphinAction
    public void reset() {
        model.setFirstValue(null);
        model.setSecondValue(null);
        model.setResult(null);
    }

    private void calc() {
        try {
            int valueA = 0;
            int valueB = 0;
            String stringValue = model.getFirstValue();
            if(stringValue != null && !stringValue.trim().isEmpty()) {
                valueA = Integer.parseInt(stringValue);
            }
            stringValue = model.getSecondValue();
            if(stringValue != null && !stringValue.trim().isEmpty()) {
                valueB = Integer.parseInt(stringValue);
            }
            model.resultProperty().set((valueA + valueB) + "");
        } catch (Exception e) {
            model.resultProperty().set("Error");
        }
    }
}