package model.services;

import java.util.List;

import model.dao.CenterDao;
import model.dao.DaoFactory;
import model.entities.Center;

public class CenterService {
	
	private CenterDao dao = DaoFactory.createCenterDao();
	
	public List<Center> findAll() {
		return dao.findAll();
	}

}
