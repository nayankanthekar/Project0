package com.efgh.service;

import java.util.List;

import com.efgh.dao.EfghDAOInterface;
import com.efgh.entity.EfghUser;
import com.efgh.entity.TimeLineEntity;
import com.efgh.utility.DAOFactory;

public class EfghService implements EfghServiceInterface {

	@Override
	public int createProfileService(EfghUser eu) {
		EfghDAOInterface ed= DAOFactory.createObject();
		return ed.createProfileDAO(eu);
	}

	@Override
	public EfghUser viewProfileService(EfghUser eu) {
		EfghDAOInterface ed= DAOFactory.createObject();
		return ed.viewProfileDAO(eu);
	}

	@Override
	public List<EfghUser> viewAllProfileService() {
		EfghDAOInterface ed=DAOFactory.createObject();
		return ed.viewAllProfileDAO();
	}

	@Override
	public int deleteProfileService(EfghUser eu) {
		EfghDAOInterface ed=DAOFactory.createObject();
		return ed.deleteProfileDAO(eu);
	}

	@Override
	public EfghUser loginProfileService(EfghUser eu) {
		EfghDAOInterface ed=DAOFactory.createObject();
		return ed.loginProfileDAO(eu);
	}

	@Override
	public List<TimeLineEntity> timelineService(EfghUser eu) {
		EfghDAOInterface ed=DAOFactory.createObject();
		return ed.timelineProfileDAO(eu);
	}

	@Override
	public List<TimeLineEntity> timelineService1(EfghUser lu) {
		// TODO Auto-generated method stub
		return null;
	}


}
