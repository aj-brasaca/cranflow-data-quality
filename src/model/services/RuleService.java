package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.RuleDao;
import model.entities.Rule;

public class RuleService {

	private RuleDao dao = DaoFactory.createRuleDao();
		
	public List<Rule> findAll() {
		return dao.findAll();
	}
	
}
