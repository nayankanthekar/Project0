package com.efgh.utility;

import com.efgh.dao.EfghDAO;
import com.efgh.dao.EfghDAOInterface;

public class DAOFactory {
	
	private DAOFactory() {
		
	}

	public static EfghDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new EfghDAO();
	}

}
