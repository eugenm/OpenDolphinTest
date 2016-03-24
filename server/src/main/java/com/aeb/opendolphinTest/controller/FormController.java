package com.aeb.opendolphinTest.controller;

import com.aeb.opendolphinTest.Constants;
import com.aeb.opendolphinTest.model.FormViewModel;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;

@DolphinController(Constants.CONTROLLER_NAME)
public class FormController {

	@DolphinModel
	private FormViewModel model;

}
