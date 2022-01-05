package com.efgh.service;

import java.util.List;

import com.efgh.entity.EfghUser;
import com.efgh.entity.TimeLineEntity;
import com.efgh.entity.EfghUser;

public interface EfghServiceInterface {

	int createProfileService(EfghUser eu);

	EfghUser viewProfileService(EfghUser eu);

	List<TimeLineEntity> timelineService1(EfghUser lu);
	
	int deleteProfileService(EfghUser eu);

	EfghUser loginProfileService(EfghUser eu);

	List<TimeLineEntity> timelineService(EfghUser eu);

	List<EfghUser> viewAllProfileService();

}
