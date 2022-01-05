package com.efgh.utility;

import com.efgh.controller.EfghController;
import com.efgh.controller.EfghControllerInterface;

public class ControllerFactory {
	
	private ControllerFactory() {
		
	}

	public static EfghControllerInterface createobject() {
		// TODO Auto-generated method stub
		return new EfghController();
	}

}
