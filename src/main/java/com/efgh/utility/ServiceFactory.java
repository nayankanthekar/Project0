package com.efgh.utility;

import com.efgh.service.EfghService;
import com.efgh.service.EfghServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}

	public static EfghServiceInterface createObject() {
		// TODO Auto-generated method stub
		return new EfghService();
	}

}
