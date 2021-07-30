package model.dao;

import java.util.List;

import model.entities.Center;

public interface CenterDao {

	void insert(Center obj);
	void update(Center obj);
	void deleteById(Integer id);
	Center findById(Integer id);
	List<Center> findAll();

}
