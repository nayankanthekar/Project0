package com.efgh;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.efgh.dao.EfghDAO;
import com.efgh.dao.EfghDAOInterface;
import com.efgh.entity.EfghUser;
public class DAOTesting {
	
	private EfghDAOInterface ed;

	@Before
	public void setUp() throws Exception {
		ed=new EfghDAO();
	}

	@After
	public void tearDown() throws Exception {
		ed=null;
	}

	@Test
	public void testCreateProfileDAO() {
		EfghUser eu=new EfghUser();
		eu.setName("Mohan");
		eu.setPassword("sss");
		eu.setEmail("s");
		eu.setAddress("Chennai");
		int i=ed.createProfileDAO(eu);
		assert i>0:"profile creation failed";
	}

	@Test
	public void testViewProfileDAO() {
		
		EfghUser eu=new EfghUser();
		eu.setEmail("m@gmail.com");
		
		EfghUser i=ed.viewProfileDAO(eu);
		assert i!=null:"Profile not found";
		
	}

}
