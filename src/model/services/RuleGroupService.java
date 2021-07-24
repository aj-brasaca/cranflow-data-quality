package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.RuleGroupDao;
import model.entities.RuleGroup;

public class RuleGroupService {

	private RuleGroupDao dao = DaoFactory.createRuleGroupDao();
	
	public List<RuleGroup> findAll() {
		return dao.findAll();
	}
}
