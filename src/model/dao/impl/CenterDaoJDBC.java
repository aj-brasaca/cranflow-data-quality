package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.CenterDao;
import model.entities.Center;

public class CenterDaoJDBC implements CenterDao{

	private Connection conn;

	public CenterDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	
	@Override
	public void insert(Center obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Center obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Center findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Center> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
