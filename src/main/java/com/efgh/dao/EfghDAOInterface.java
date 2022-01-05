package com.efgh.dao;

import java.util.List;

import com.efgh.entity.EfghUser;
import com.efgh.entity.EfghUser;
import com.efgh.entity.TimeLineEntity;

public interface EfghDAOInterface {

	int createProfileDAO(EfghUser eu);

	EfghUser viewProfileDAO(EfghUser eu);
	List<EfghUser> viewAllProfileDAO();

	int deleteProfileDAO(EfghUser eu);

	EfghUser loginProfileDAO(EfghUser eu);

	List<TimeLineEntity> timelineProfileDAO(EfghUser eu);


}
