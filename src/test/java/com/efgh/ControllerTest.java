package com.efgh;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.efgh.controller.EfghControllerInterface;
import com.efgh.utility.ControllerFactory;

public class ControllerTest {
	
	private EfghControllerInterface ei;

	@Before
	public void setUp() throws Exception {
		ei=ControllerFactory.createobject();
	}

	@After
	public void tearDown() throws Exception {
		ei=null;
	}

	@Test
	public void testCreateProfileController() {
		int i=ei.createProfileController();
		assert i>0:"profile created";
	}

	@Test
	public void testViewProfileController() {
		int i1=ei.viewProfileController();
		assert i1>0:"Profile not found";
	}

}
