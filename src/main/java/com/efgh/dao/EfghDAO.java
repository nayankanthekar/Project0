package com.efgh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.efgh.entity.EfghUser;
import com.efgh.entity.EfghUser;
import com.efgh.entity.TimeLineEntity;

public class EfghDAO implements EfghDAOInterface {

	@Override
	public int createProfileDAO(EfghUser eu) {
		int i=0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","nayan");
			PreparedStatement ps=con.prepareStatement("insert into efghuser values(?,?,?,?)");
			ps.setString(1, eu.getName() );
			ps.setString(2, eu.getEmail());
			ps.setString(3, eu.getAddress());
			ps.setString(4, eu.getPassword());
			i=ps.executeUpdate();
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public EfghUser viewProfileDAO(EfghUser eu) {
		EfghUser ee=null;
      try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","nayan");
			PreparedStatement ps=con.prepareStatement("select * from efghuser where email=?");
			ps.setString(1, eu.getEmail());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				ee=new EfghUser();
				ee.setName(res.getString(1));
				ee.setEmail(res.getString(2));
				ee.setAddress(res.getString(3));
				ee.setPassword(res.getString(4));
			}
			}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return ee;
	}

	@Override
	public List<EfghUser> viewAllProfileDAO() {
		List<EfghUser> ee1 = new ArrayList<EfghUser>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "system", "nayan");
			PreparedStatement ps = con.prepareStatement("select * from efghuser");

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				EfghUser ee = new EfghUser();
				ee.setName(res.getString(1));
				ee.setPassword(res.getString(2));
				ee.setEmail(res.getString(3));
				ee.setAddress(res.getString(4));

				ee1.add(ee);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ee1;
	}

	@Override
	public int deleteProfileDAO(EfghUser eu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "system", "nayan");
			PreparedStatement ps = con.prepareStatement("delete from efghuser where email=?");

			ps.setString(1, eu.getEmail());

			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public EfghUser loginProfileDAO(EfghUser eu) {
		EfghUser ee = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "system", "nayan");
			PreparedStatement ps = con.prepareStatement("select * from efghuser where email=? and password=?");

			ps.setString(1, eu.getEmail());
			ps.setString(2, eu.getPassword());

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				ee = new EfghUser();
				ee.setName(res.getString(1));
				ee.setPassword(res.getString(2));
				ee.setEmail(res.getString(3));
				ee.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ee;
	}

	@Override
	public List<TimeLineEntity> timelineProfileDAO(EfghUser eu) {
		List<TimeLineEntity> ee1 = new ArrayList<TimeLineEntity>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "system", "nayan");
			PreparedStatement ps = con.prepareStatement("select * from timeline where receiver=?");
			ps.setString(1, eu.getEmail());
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				TimeLineEntity ee = new TimeLineEntity();
				ee.setSender(res.getString(1));
				ee.setTimeofmessage(res.getString(2));
				ee.setMessage(res.getString(3));
				ee.setReceiver(res.getString(4));

				ee1.add(ee);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ee1;
	}

}
