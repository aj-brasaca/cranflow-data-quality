package model.dao;

import java.util.List;

import model.entities.RuleGroup;

public interface RuleGroupDao {

	void insert(RuleGroup obj);
	void update(RuleGroup obj);
	void deleteById(Integer id);
	RuleGroup findById(Integer id);
	List<RuleGroup> findAll();
	
}
